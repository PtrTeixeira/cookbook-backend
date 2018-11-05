package com.github.ptrteixeira.punchcard

import com.github.ptrteixeira.punchcard.base.BaseModule
import com.tylerkindy.dropwizard.dagger.DaggerApplication
import com.tylerkindy.dropwizard.dagger.DropwizardInjector
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.conscrypt.OpenSSLProvider
import java.security.Security

class StravaPunchcardApplication : DaggerApplication<StravaPunchcardConfiguration>() {
    init {
        Security.addProvider(OpenSSLProvider())
    }

    override fun applicationInjector(configuration: StravaPunchcardConfiguration, environment: Environment): DropwizardInjector<out DaggerApplication<*>> {
        return DaggerApplicationComponent.builder()
                .baseModule(BaseModule(configuration))
                .build()
    }

    override fun initialize(bootstrap: Bootstrap<StravaPunchcardConfiguration>) {
        super.initialize(bootstrap)

        bootstrap.configurationSourceProvider =
                SubstitutingSourceProvider(bootstrap.configurationSourceProvider, EnvironmentVariableSubstitutor(false))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            StravaPunchcardApplication()
                    .run(*args)
        }
    }
}