package com.github.ptrteixeira.cookbook.core

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.dropwizard.testing.FixtureHelpers
import io.dropwizard.testing.FixtureHelpers.fixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RecipeTest {
    private val objectMapper = jacksonObjectMapper()

    private val sampleRecipe = Recipe(
        userId = "test",
        id = 101,
        name = "Chocolate Chip Cookies",
        ingredients = listOf("Chocolate", "Chips", "Cookies"),
        instructions = "Mix",
        summary = "They were invented right here in Massachusetts, you know",
        description = "They're chocolate chip cookies. Waddya want?"
    )

    @Test
    fun itCanBeSerialized() {
        val serialized = objectMapper.writeValueAsString(sampleRecipe)
        val expected = objectMapper
            .writeValueAsString(objectMapper.readValue(fixture("recipe.json"), Recipe::class.java))

        Assertions.assertThat(serialized)
            .isEqualTo(expected)
    }

    @Test
    fun itCanBeDeserialized() {
        val deserialized = objectMapper
            .readValue(FixtureHelpers.fixture("recipe.json"), Recipe::class.java)

        Assertions.assertThat(deserialized)
            .isEqualTo(sampleRecipe)
    }
}
