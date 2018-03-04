package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.config.AuthConfiguration
import com.github.ptrteixeira.cookbook.core.User
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import dagger.Module
import dagger.Provides
import io.dropwizard.auth.Authenticator
import javax.inject.Named

@Module
internal class AuthModule {
    @Provides
    fun httpTransport(): HttpTransport = NetHttpTransport()

    @Provides
    fun googleTokenVerifier(authConfig: AuthConfiguration,
                            httpTransport: HttpTransport,
                            jsonFactory: JsonFactory): GoogleIdTokenVerifier {
        return authConfig.clientId.map {
            GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
                .setAudience(listOf(it))
                .build()
        }.orElseThrow { IllegalStateException() }
    }

    @Provides
    @Named(AuthComponent.USERNAME_AUTH)
    fun usernameAuth(raw: TrivialAuth): Authenticator<String, User> = raw

    @Provides
    @Named(AuthComponent.TOKEN_AUTH)
    fun tokenAuth(raw: TokenAuth): Authenticator<String, User> = raw
}
