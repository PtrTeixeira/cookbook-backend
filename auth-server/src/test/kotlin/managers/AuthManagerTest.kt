package com.github.ptrteixeira.cookbook.auth.managers

import com.github.ptrteixeira.cookbook.auth.data.UserDao
import com.github.ptrteixeira.cookbook.core.User
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

internal class AuthManagerTest {
    @Mock
    private lateinit var dao: UserDao
    @Mock
    private lateinit var tokenVerifier: GoogleIdTokenVerifier

    private lateinit var authManager: AuthManager

    @BeforeEach
    fun initMocks() {
        MockitoAnnotations.initMocks(this)

        authManager = AuthManager(tokenVerifier, dao)
    }

    @Test
    fun `when given an invalid Google token getUserForGoogleToken returns null`() {
        given(tokenVerifier.verify(anyString())).willReturn(null)

        // when
        val foundUser = authManager.getUserForGoogleToken("google-jwt-token")

        // then
        assertThat(foundUser)
                .isNull()
    }

    @Test
    fun `when given a valid Google token for a user not in the database a new user is created`() {
        val validToken = mock(GoogleIdToken::class.java)
        val payload = GoogleIdToken.Payload()
        payload.subject = "user-id"
        payload.email = "user-email"

        given(validToken.payload).willReturn(payload)
        given(tokenVerifier.verify(anyString())).willReturn(validToken)

        // when
        val newUser = authManager.getUserForGoogleToken("google-jwt-token")

        // then
        verify(dao).createFromGoogleToken("user-id", "user-email")
        assertThat(newUser?.googleId).isEqualTo("user-id")
        assertThat(newUser?.userName).isEqualTo("user-email")
    }

    @Test
    fun `when given a valid Google token for a user in the database, the user record is returned`() {
        val validToken = mock(GoogleIdToken::class.java)
        val payload = GoogleIdToken.Payload()
        payload.subject = "user-id"
        payload.email = "user-email"

        given(validToken.payload).willReturn(payload)
        given(tokenVerifier.verify(anyString())).willReturn(validToken)
        given(dao.getByGoogleId("user-id")).willReturn(User(
                id = "0",
                userName = "user-email",
                googleId = "user-id"
        ))

        // when
        val foundUser = authManager.getUserForGoogleToken("google-jwt-token")

        // then
        assertThat(foundUser?.userName).isEqualTo("user-email")
        assertThat(foundUser?.id).isEqualTo("0")
    }
}