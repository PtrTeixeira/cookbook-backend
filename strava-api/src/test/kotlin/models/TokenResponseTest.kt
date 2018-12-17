package models

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.strava.api.models.TokenResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TokenResponseTest {
    private val objectMapper = ObjectMapper().registerKotlinModule()

    @Test
    fun `it can deserialize token responses with state without athlete`() {
        val accessToken = "987654321234567898765432123456789"
        val state = "STRAVA"

        val json = """
            {
  "token_type": "Bearer",
  "access_token": "$accessToken",
  "refresh_token": "1234567898765432112345678987654321",
  "expires_at": 1531378346,
  "state": "$state"
}
        """.trimIndent()

        val tokenResponse = objectMapper.readValue(json, TokenResponse::class.java)
        assertThat(tokenResponse.athlete)
            .isNull()
        assertThat(tokenResponse.accessToken)
            .isEqualTo(accessToken)
        assertThat(tokenResponse.state)
            .isEqualTo(state)
    }

    @Test
    fun `it can deserialize token responses without state or athlete`() {
        val accessToken = "987654321234567898765432123456789"

        val json = """
            {
  "token_type": "Bearer",
  "access_token": "$accessToken",
  "refresh_token": "1234567898765432112345678987654321",
  "expires_at": 1531378346
}
        """.trimIndent()

        val tokenResponse = objectMapper.readValue(json, TokenResponse::class.java)
        assertThat(tokenResponse.athlete)
            .isNull()
        assertThat(tokenResponse.accessToken)
            .isEqualTo(accessToken)
    }
}