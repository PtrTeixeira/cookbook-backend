package com.github.ptrteixeira.punchcard

import com.github.ptrteixeira.punchcard.base.BaseModule
import com.github.ptrteixeira.punchcard.base.ObjectMapperModule
import com.github.ptrteixeira.punchcard.resources.ResourcesModule
import com.tylerkindy.dropwizard.dagger.DropwizardInjectionModule
import com.tylerkindy.dropwizard.dagger.DropwizardInjector
import dagger.Component

@Component(modules = [
    ObjectMapperModule::class,
    BaseModule::class,
    DropwizardInjectionModule::class,
    ResourcesModule::class
])
interface ApplicationComponent : DropwizardInjector<StravaPunchcardApplication>