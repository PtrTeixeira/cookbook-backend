package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.auth.AuthModule
import com.github.ptrteixeira.cookbook.base.BaseModule
import com.github.ptrteixeira.cookbook.base.ObjectMapperModule
import com.github.ptrteixeira.cookbook.data.DataModule
import com.github.ptrteixeira.cookbook.resources.ResourcesModule
import com.tylerkindy.dropwizard.dagger.DropwizardInjectionModule
import com.tylerkindy.dropwizard.dagger.DropwizardInjector
import dagger.Component

@Component(modules = [
    ObjectMapperModule::class,
    BaseModule::class,
    DataModule::class,
    AuthModule::class,
    DropwizardInjectionModule::class,
    ResourcesModule::class
])
interface ApplicationComponent : DropwizardInjector<CookbookApplication>