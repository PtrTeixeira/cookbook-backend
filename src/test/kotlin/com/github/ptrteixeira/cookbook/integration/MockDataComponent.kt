package com.github.ptrteixeira.cookbook.integration

import com.github.ptrteixeira.cookbook.data.DataComponent
import dagger.Component

@Component(modules = arrayOf(MockDataModule::class))
interface MockDataComponent : DataComponent
