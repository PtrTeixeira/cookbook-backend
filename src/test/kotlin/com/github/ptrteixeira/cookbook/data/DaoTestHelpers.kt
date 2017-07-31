package com.github.ptrteixeira.cookbook.data

import liquibase.Contexts
import liquibase.Liquibase
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import org.jdbi.v3.core.Jdbi

internal fun jdbi(): Jdbi {
    val jdbi = Jdbi.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")
    jdbi.installPlugins()
        .registerArrayType(String::class.java, "varchar")
    return jdbi
}

internal fun migrate(jdbi: Jdbi)  = jdbi.inTransaction<Unit, Nothing> {
    val connection = JdbcConnection(it.connection)
    val liquibase = Liquibase("migrations.xml", ClassLoaderResourceAccessor(), connection)
    liquibase.update(Contexts())
}
