package com.github.ptrteixeira.cookbook.auth.data

import com.github.ptrteixeira.cookbook.core.User
import liquibase.Contexts
import liquibase.Liquibase
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import org.assertj.core.api.Assertions.assertThat
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.kotlin.onDemand
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserDaoTest {
    private lateinit var userDao: UserDao

    @Test
    fun itCanSelectExistingUsersByGoogleId() {
        val generatedKey = userDao.createFromGoogleToken("0", "userName")
        val user = User(generatedKey.toString(), "0", "userName")

        val result = userDao.getByGoogleId("0")
        assertThat(result)
                .isNotNull()
                .isEqualTo(user)
    }

    @Test
    fun itReturnsNullWhenNoExistingUserIsFound() {
        val result = userDao.getByGoogleId("1")
        assertThat(result)
                .isNull()
    }


    @BeforeEach
    fun truncateTable() {
        dbi.withHandle<Unit, Nothing> {
            it.createUpdate("DELETE FROM USERS")
                    .execute()
        }
        userDao = dbi.onDemand()
    }

    companion object {
        private val dbi = jdbi()

        @BeforeAll
        @JvmStatic
        fun migrate() {
            dbi.inTransaction<Unit, Nothing> {
                val connection = JdbcConnection(it.connection)
                val liquibase = Liquibase("migrations.xml", ClassLoaderResourceAccessor(), connection)
                liquibase.update(Contexts())
            }
        }

        @JvmStatic
        private fun jdbi(): Jdbi {
            return Jdbi
                    .create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")
                    .installPlugins()
        }
    }
}
