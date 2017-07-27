package com.github.ptrteixeira.cookbook.model

enum class ErrorType(val code: Int) {
    /**
     * Indicates that no credentials were sent (or that sent credentials don't belong to a real user),
     * so the user could not be identified.
     */
    NO_USER(401),
    /**
     * Indicates that credentials were sent and the user successfully identified, but that user does not have permission
     * to view the requested resource.
     */
    FORBIDDEN(403),
    /**
     * Indicates that the requested resource could not be found.
     */
    NOT_FOUND(404)
}
