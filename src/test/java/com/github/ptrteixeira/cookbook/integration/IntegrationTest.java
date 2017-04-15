package com.github.ptrteixeira.cookbook.integration;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated test will be slow -
 * in particular, it either spins up a server or
 * connects to an external resource.
 *
 * Unless you're patient, it probably shouldn't be
 * run locally.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Tag("IntegrationTest")
@interface IntegrationTest { }
