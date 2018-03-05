package com.github.ptrteixeira.cookbook.auth.data

import com.github.ptrteixeira.cookbook.core.User
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

interface UserDao {
    @SqlQuery("""
SELECT id, google_id AS googleId, user_name AS userName
FROM USERS
WHERE google_id = :googleId
    """)
    fun getByGoogleId(googleId: String): User?

    @SqlUpdate("""
INSERT INTO USERS (google_id, user_name)
VALUES (:googleId, :userName)
        """)
    @GetGeneratedKeys
    fun createFromGoogleToken(googleId: String, userName: String): Int
}

