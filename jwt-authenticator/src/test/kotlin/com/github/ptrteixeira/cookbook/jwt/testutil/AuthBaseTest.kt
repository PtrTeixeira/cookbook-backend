package com.github.ptrteixeira.cookbook.jwt.testutil

import io.dropwizard.jersey.DropwizardResourceConfig
import io.dropwizard.logging.BootstrapLogging
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown
import org.glassfish.jersey.servlet.ServletProperties
import org.glassfish.jersey.test.DeploymentContext
import org.glassfish.jersey.test.JerseyTest
import org.glassfish.jersey.test.ServletDeploymentContext
import org.glassfish.jersey.test.TestProperties
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory
import org.glassfish.jersey.test.spi.TestContainerException
import org.glassfish.jersey.test.spi.TestContainerFactory
import org.junit.jupiter.api.Test
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.HttpHeaders

abstract class AuthBaseTest<T : DropwizardResourceConfig> : JerseyTest() {

    protected abstract val dropwizardResourceConfig: DropwizardResourceConfig
    protected abstract val dropwizardResourceConfigClass: Class<T>
    protected abstract val prefix: String
    protected abstract val ordinaryGuyValidToken: String
    protected abstract val goodGuyValidToken: String
    protected abstract val badGuyToken: String

    @Throws(TestContainerException::class)
    override fun getTestContainerFactory(): TestContainerFactory {
        return GrizzlyWebTestContainerFactory()
    }

    override fun configureDeployment(): DeploymentContext {
        forceSet(TestProperties.CONTAINER_PORT, "0")
        return ServletDeploymentContext.builder(dropwizardResourceConfig)
                .initParam(ServletProperties.JAXRS_APPLICATION_CLASS, dropwizardResourceConfigClass.name)
                .build()
    }

    @Test
    @Throws(Exception::class)
    fun respondsToMissingCredentialsWith401() {
        try {
            target("/test/admin").request().get(String::class.java)
            failBecauseExceptionWasNotThrown(WebApplicationException::class.java)
        } catch (e: WebApplicationException) {
            assertThat(e.response.status).isEqualTo(401)
            assertThat(e.response.headers[HttpHeaders.WWW_AUTHENTICATE])
                    .containsOnly("$prefix realm=\"realm\"")
        }

    }

    @Test
    fun resourceWithoutAuth200() {
        assertThat(target("/test/noauth").request()
                .get(String::class.java))
                .isEqualTo("hello")
    }

    @Test
    fun resourceWithAuthenticationWithoutAuthorizationWithCorrectCredentials200() {
        assertThat(target("/test/profile").request()
                .header(HttpHeaders.AUTHORIZATION, "$prefix $ordinaryGuyValidToken")
                .get(String::class.java))
                .isEqualTo("'$ORDINARY_USER' has user privileges")
    }

    @Test
    fun resourceWithAuthenticationWithoutAuthorizationNoCredentials401() {
        try {
            target("/test/profile").request().get(String::class.java)
            failBecauseExceptionWasNotThrown(WebApplicationException::class.java)
        } catch (e: WebApplicationException) {
            assertThat(e.response.status).isEqualTo(401)
            assertThat(e.response.headers[HttpHeaders.WWW_AUTHENTICATE])
                    .containsOnly("$prefix realm=\"realm\"")
        }

    }

    @Test
    fun resourceWithValidOptionalAuthentication200() {
        assertThat(target("/test/optional").request()
                .header(HttpHeaders.AUTHORIZATION, "$prefix $ordinaryGuyValidToken")
                .get(String::class.java))
                .isEqualTo("principal was present")
    }

    @Test
    fun resourceWithInvalidOptionalAuthentication200() {
        assertThat(target("/test/optional").request()
                .header(HttpHeaders.AUTHORIZATION, "$prefix $badGuyToken")
                .get(String::class.java))
                .isEqualTo("principal was not present")
    }

    @Test
    fun resourceWithoutOptionalAuthentication200() {
        assertThat(target("/test/optional").request()
                .get(String::class.java))
                .isEqualTo("principal was not present")
    }

    @Test
    fun resourceWithAuthorizationPrincipalIsNotAuthorized403() {
        try {
            target("/test/admin").request()
                    .header(HttpHeaders.AUTHORIZATION, "$prefix $ordinaryGuyValidToken")
                    .get(String::class.java)
            failBecauseExceptionWasNotThrown(WebApplicationException::class.java)
        } catch (e: WebApplicationException) {
            assertThat(e.response.status).isEqualTo(403)
        }

    }

    @Test
    fun resourceWithDenyAllAndNoAuth401() {
        try {
            target("/test/denied").request().get(String::class.java)
            failBecauseExceptionWasNotThrown(WebApplicationException::class.java)
        } catch (e: WebApplicationException) {
            assertThat(e.response.status).isEqualTo(401)
        }

    }

    @Test
    fun resourceWithDenyAllAndAuth403() {
        try {
            target("/test/denied").request()
                    .header(HttpHeaders.AUTHORIZATION, "$prefix $goodGuyValidToken")
                    .get(String::class.java)
            failBecauseExceptionWasNotThrown(WebApplicationException::class.java)
        } catch (e: WebApplicationException) {
            assertThat(e.response.status).isEqualTo(403)
        }

    }

    @Test
    @Throws(Exception::class)
    fun transformsCredentialsToPrincipals() {
        assertThat(target("/test/admin").request()
                .header(HttpHeaders.AUTHORIZATION, "$prefix $goodGuyValidToken")
                .get(String::class.java))
                .isEqualTo("'$ADMIN_USER' has admin privileges")
    }

    @Test
    @Throws(Exception::class)
    fun transformsCredentialsToPrincipalsWhenAuthAnnotationExistsWithoutMethodAnnotation() {
        assertThat(target("/test/implicit-permitall").request()
                .header(HttpHeaders.AUTHORIZATION, "$prefix $goodGuyValidToken")
                .get(String::class.java))
                .isEqualTo("'$ADMIN_USER' has user privileges")
    }

    @Test
    @Throws(Exception::class)
    fun respondsToNonBasicCredentialsWith401() {
        try {
            target("/test/admin").request()
                    .header(HttpHeaders.AUTHORIZATION, "Derp irrelevant")
                    .get(String::class.java)
            failBecauseExceptionWasNotThrown(WebApplicationException::class.java)
        } catch (e: WebApplicationException) {
            assertThat(e.response.status).isEqualTo(401)
            assertThat(e.response.headers[HttpHeaders.WWW_AUTHENTICATE])
                    .containsOnly("$prefix realm=\"realm\"")
        }

    }

    @Test
    @Throws(Exception::class)
    fun respondsToExceptionsWith500() {
        try {
            target("/test/admin").request()
                    .header(HttpHeaders.AUTHORIZATION, "$prefix $badGuyToken")
                    .get(String::class.java)
            failBecauseExceptionWasNotThrown(WebApplicationException::class.java)
        } catch (e: WebApplicationException) {
            assertThat(e.response.status).isEqualTo(500)
        }

    }

    companion object {
        protected val ADMIN_ROLE = "ADMIN"
        protected val ADMIN_USER = "good-guy"
        protected val ORDINARY_USER = "ordinary-guy"
        protected val BADGUY_USER = "bad-guy"
        protected val CUSTOM_PREFIX = "Custom"
        protected val BEARER_PREFIX = "Bearer"
        protected val BASIC_PREFIX = "Basic"
        protected val ORDINARY_USER_ENCODED_TOKEN = "b3JkaW5hcnktZ3V5OnNlY3JldA=="
        protected val GOOD_USER_ENCODED_TOKEN = "Z29vZC1ndXk6c2VjcmV0"
        protected val BAD_USER_ENCODED_TOKEN = "YmFkLWd1eTpzZWNyZXQ="

        init {
            BootstrapLogging.bootstrap()
        }
    }
}