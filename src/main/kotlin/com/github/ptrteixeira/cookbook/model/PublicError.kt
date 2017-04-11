package com.github.ptrteixeira.cookbook.model

/**
 * Represents a public error to be served by the API. That is,
 * if there is a (non-500) error returned from the API, it will
 * also return an instance of this class which provides more
 * information about what exactly went wrong.
 *
 * @property error - Short description of what went wrong. Eg, "Not Found"
 * @property errorDescription - More complete description of what went wrong. Eg, "Recipe 1010101 does not exist"
 * @property errorUri - Link to webpage with more information about the error
 */
data class PublicError(
    val error: String,
    val errorDescription: String,
    val errorUri: String?
)