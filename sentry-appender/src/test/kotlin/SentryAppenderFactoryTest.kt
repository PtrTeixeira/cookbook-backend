import com.github.ptrteixeira.cookbook.sentry.SentryAppenderFactory
import io.dropwizard.jackson.DiscoverableSubtypeResolver
import io.dropwizard.logging.BootstrapLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SentryAppenderFactoryTest {
    @BeforeEach
    fun init() {
        BootstrapLogging.bootstrap()
    }

    @Test
    fun isDiscoverable() {
        assertThat(DiscoverableSubtypeResolver().discoveredSubtypes)
            .contains(SentryAppenderFactory::class.java)
    }
}