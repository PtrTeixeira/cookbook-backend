package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.data.DataModule
import liquibase.Contexts
import liquibase.Liquibase
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import org.jdbi.v3.core.Jdbi
import org.mockito.Mockito

internal fun jdbi(): Jdbi {
    val jdbi = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")
    return DataModule().configuredJdbi(jdbi)
}

internal fun migrate(jdbi: Jdbi) = jdbi.inTransaction<Unit, Nothing> {
    val connection = JdbcConnection(it.connection)
    val liquibase = Liquibase("migrations.xml", ClassLoaderResourceAccessor(), connection)
    liquibase.update(Contexts())
}

internal inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)
