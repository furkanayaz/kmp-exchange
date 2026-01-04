package org.ayaz.chatter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform