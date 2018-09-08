package com.github.ptrteixeira.punchcard.resources

import com.tylerkindy.dropwizard.dagger.Resource
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
internal interface ResourcesModule {
    @Binds
    @IntoSet
    fun bindAuthResource(authResource: AuthResource): Resource

    @Binds
    @IntoSet
    fun bindMetricsResource(metricsResource: MetricsResource): Resource

    @Binds
    @IntoSet
    fun bindPunchcardResource(punchcardResource: PunchcardResource): Resource

    companion object {
        const val AUTH_TOKEN_NAME = "StravaAuthToken"
    }
}