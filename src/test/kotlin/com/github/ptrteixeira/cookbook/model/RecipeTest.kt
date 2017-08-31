package com.github.ptrteixeira.cookbook.model

import com.fasterxml.jackson.module.kotlin.readValue
import io.dropwizard.testing.FixtureHelpers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import com.github.ptrteixeira.cookbook.base.objectMapper as mapperFactory

internal class RecipeTest {
    private val objectMapper = mapperFactory()

    private val sampleRecipe = Recipe(
        userId = "test",
        id = 101,
        name="Chocolate Chip Cookies",
        ingredients = listOf("Chocolate", "Chips", "Cookies"),
        instructions = "Mix",
        summary = "They were invented right here in Massachusetts, you know",
        description = "They're chocolate chip cookies. Waddya want?"
    )

    @Test
    fun itCanBeSerialized() {
        val serialized = objectMapper.writeValueAsString(sampleRecipe)
        val expected = objectMapper
            .writeValueAsString(objectMapper
                .readValue<Recipe>(FixtureHelpers.fixture("fixtures/recipe.json")))

        Assertions.assertThat(serialized)
            .isEqualTo(expected)
    }

    @Test
    fun itCanBeDeserialized() {
        val deserialized: Recipe = objectMapper.readValue(FixtureHelpers.fixture("fixtures/recipe.json"))

        Assertions.assertThat(deserialized)
            .isEqualTo(sampleRecipe)
    }
}
