package com.github.ptrteixeira.cookbook.auth

import com.codahale.metrics.MetricRegistry
import com.github.ptrteixeira.cookbook.auth.data.UserDao
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.setup.Environment
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.impl.crypto.MacProvider
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.kotlin.onDemand
import java.security.Key

@Module
class AuthModule(private val config: AuthConfiguration,
                 private val environment: Environment) {

    @Provides
    fun signatureAlgorithm(): SignatureAlgorithm {
        return SignatureAlgorithm.HS512
    }

    @Provides
    fun signingKey(algorithm: SignatureAlgorithm): Key {
        return MacProvider.generateKey(algorithm)
    }

    @Provides
    fun dataSourceFactory(): DataSourceFactory = config.database

    @Provides
    fun getMetricsRegistry(): MetricRegistry = environment.metrics()

    @Provides
    @Reusable
    fun configuredJdbi(database: DataSourceFactory, metrics: MetricRegistry): Jdbi {
        return Jdbi
                .create(database.build(metrics, "h2"))
                .installPlugins()
                .registerArrayType(String::class.java, "varchar")
    }

    @Provides
    fun getHttpTransport(): HttpTransport = NetHttpTransport()

    @Provides
    fun getJacksonFactory(): JacksonFactory = JacksonFactory()


    @Provides
    fun googleTokenVerifier(httpTransport: HttpTransport,
                            jacksonFactory: JacksonFactory): GoogleIdTokenVerifier {
        return GoogleIdTokenVerifier.Builder(httpTransport, jacksonFactory)
                .setAudience(listOf(config.googleAppToken))
                .build()
    }

    @Provides
    fun getUserDao(jdbi: Jdbi): UserDao {
        return jdbi.onDemand()
    }
}