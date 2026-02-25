package org.ayaz.spx500.data.sessions.token

import redis.clients.jedis.RedisClient
import redis.clients.jedis.params.SetParams

interface ITokenSession {
    fun addToken(uuid: String, token: String): String
    fun removeToken(uuid: String): Long
}

class TokenSession(
    private val redisClient: RedisClient
): ITokenSession {
    private companion object {
        const val BASE_KEY = "token"
        const val EXPIRE_MILLIS = 1000 * 60 * 60 * 2L
    }

    private fun getKey(uuid: String): String = "$BASE_KEY:$uuid"

    override fun addToken(uuid: String, token: String): String {
        return redisClient.set(getKey(uuid), token, SetParams().px(EXPIRE_MILLIS))
    }

    override fun removeToken(uuid: String): Long {
        return redisClient.del(getKey(uuid))
    }
}