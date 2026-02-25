package org.ayaz.spx500.data.repositories.user

import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import org.ayaz.spx500.data.entities.user.UserEntity
import org.litote.kmongo.findOne

fun interface IUserGetUuidRepo {
    fun getUuid(email: String?): String?
}

class UserGetUuidRepo(
    private val userCollection: MongoCollection<UserEntity>
): IUserGetUuidRepo {
    override fun getUuid(email: String?): String? {
        if (email == null) return null

        val uuid = userCollection.findOne(Filters.eq(UserEntity::email.name, email))?.id ?: return null
        return uuid.toString()
    }
}