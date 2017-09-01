package com.github.ptrteixeira.cookbook.base

import javax.inject.Qualifier

/**
 * Qualifier annotation that indicates that an object has been created but _has not yet been
 * configured_. It should _not_ be used outside of a function which transforms an
 * `@Raw` instance into a real instance that can be used by other things.
 *
 * The particular use case of this is where I have different database connections that
 * need to be configured the same way.
 */
@Qualifier
@Retention
@MustBeDocumented
annotation class Raw
