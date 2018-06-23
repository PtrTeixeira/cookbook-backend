package com.github.ptrteixeira.punchcard

import io.dropwizard.Configuration

data class StravaPunchcardConfiguration(
        val baseUrl: String = "",
        val dashboardUiUrl: String = "",
        val stravaClientId: String = "",
        val stravaClientSecret: String = ""
) : Configuration()