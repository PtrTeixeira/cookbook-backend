package com.github.ptrteixeira.cookbook.model

import com.fasterxml.jackson.module.kotlin.readValue
import com.github.ptrteixeira.cookbook.base.ObjectMapperModule
import com.github.ptrteixeira.cookbook.core.RecipeEgg
import com.github.ptrteixeira.cookbook.core.User
import io.dropwizard.testing.FixtureHelpers.fixture
import org.assertj.core.api.AbstractObjectAssert
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.from
import org.junit.jupiter.api.Test

internal class RecipeEggTest {
    private val objectMapper = ObjectMapperModule().objectMapper()

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
            .writeValueAsString(objectMapper
                .readValue<RecipeEgg>(fixture("fixtures/recipe-egg.json")))

        assertThat(serialized) {
            isEqualTo(expected)
        }
    }

    @Test
    fun itCanBeDeserialized() {
        val deserialized: RecipeEgg = objectMapper
            .readValue(fixture("fixtures/recipe-egg.json"))

        assertThat(deserialized) {
            isEqualTo(sampleRecipeEgg)
        }
    }

    @Test
    fun itFillsInAbsentFieldsWithDefaultValues() {
        val deserialized: RecipeEgg = objectMapper
            .readValue(fixture("fixtures/recipe-egg-absent-field.json"))

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
