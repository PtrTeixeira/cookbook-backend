package com.github.ptrteixeira.cookbook.model

import com.fasterxml.jackson.module.kotlin.readValue
import com.github.ptrteixeira.cookbook.base.BaseModule
import io.dropwizard.testing.FixtureHelpers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class PublicErrorTest {
    private val objectMapper = BaseModule().objectMapper()

    private val sampleError = PublicError(ErrorType.NOT_FOUND, "Recipe 101 could not be found")

    @Test
    fun itCanBeSerialized() {
        val serialized = objectMapper.writeValueAsString(sampleError)
        val expected = objectMapper
            .writeValueAsString(objectMapper
                .readValue<PublicError>(FixtureHelpers.fixture("fixtures/not-found-error.json")))

        Assertions.assertThat(serialized)
            .isEqualTo(expected)
    }

    @Test
    fun itCanBeDeserialized() {
        val deserialized: PublicError = objectMapper
            .readValue(FixtureHelpers.fixture("fixtures/not-found-error.json"))

        Assertions.assertThat(deserialized)
            .isEqualTo(sampleError)
    }
}
