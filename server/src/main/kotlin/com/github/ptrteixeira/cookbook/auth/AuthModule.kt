package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.config.OauthConfiguration
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
    fun googleTokenVerifier(oauthConfig: OauthConfiguration,
                            httpTransport: HttpTransport,
                            jsonFactory: JsonFactory): GoogleIdTokenVerifier {
        return GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
            .setAudience(listOf(oauthConfig.clientId))
            .build()
    }

    @Provides
    @Named(AuthComponent.TOKEN_AUTH)
    fun tokenAuth(raw: TokenAuth): Authenticator<String, User> = raw
}
