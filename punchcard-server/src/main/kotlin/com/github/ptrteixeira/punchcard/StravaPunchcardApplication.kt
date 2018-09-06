package com.github.ptrteixeira.punchcard

import com.github.ptrteixeira.punchcard.base.BaseModule
import com.tylerkindy.dropwizard.dagger.DaggerApplication
import com.tylerkindy.dropwizard.dagger.DropwizardInjector
import io.dropwizard.setup.Environment

class StravaPunchcardApplication : DaggerApplication<StravaPunchcardConfiguration>() {
    override fun applicationInjector(configuration: StravaPunchcardConfiguration, environment: Environment): DropwizardInjector<out DaggerApplication<*>> {
        return DaggerApplicationComponent.builder()
                .baseModule(BaseModule(configuration))
                .build()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            StravaPunchcardApplication()
                    .run(*args)
        }
    }
}