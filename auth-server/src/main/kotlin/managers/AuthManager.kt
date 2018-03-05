package managers

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import javax.inject.Inject

class AuthManager
@Inject internal constructor(private val tokenVerifier: GoogleIdTokenVerifier) {

}