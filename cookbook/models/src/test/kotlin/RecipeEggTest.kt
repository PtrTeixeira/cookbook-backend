package com.github.ptrteixeira.cookbook.core

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.dropwizard.testing.FixtureHelpers.fixture
import org.assertj.core.api.AbstractObjectAssert
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.from
import org.junit.jupiter.api.Test

internal class RecipeEggTest {
    private val objectMapper = jacksonObjectMapper()

    private val sampleRecipeEgg = RecipeEgg(
        name = "Chocolate Chip Cookies",
        ingredients = listOf("Chocolate", "Chips", "Cookies"),
        instructions = "Mix",
        summary = "They were invented right here in Massachusetts, you know",
        description = "They're chocolate chip cookies. Waddya want?"
    )

    @Test
    fun itCanBeSerialized() {
        val serialized = objectMapper.writeValueAsString(sampleRecipeEgg)
        val expected = objectMapper
            .writeValueAsString(objectMapper.readValue(fixture("recipe-egg.json"), RecipeEgg::class.java))

        assertThat(serialized) {
            isEqualTo(expected)
        }
    }

    @Test
    fun itCanBeDeserialized() {
        val deserialized = objectMapper
            .readValue(fixture("recipe-egg.json"), RecipeEgg::class.java)

        assertThat(deserialized) {
            isEqualTo(sampleRecipeEgg)
        }
    }

    @Test
    fun itFillsInAbsentFieldsWithDefaultValues() {
        val deserialized = objectMapper
            .readValue(fixture("recipe-egg-absent-field.json"), RecipeEgg::class.java)

        assertThat(deserialized) {
            returns("", from { it.description })
        }
    }

    @Test
    fun itCanAddAnId() {
        val recipe = sampleRecipeEgg.toRecipe(12345, User("test"))

        assertThat(recipe) {
            returns(12345, from { it.id })
            returns("test", from { it.userId })
        }
    }
}

fun <Actual> assertThat(actual: Actual, assertions: AbstractObjectAssert<*, Actual>.() -> Unit) {
    assertions(Assertions.assertThat(actual))
}
