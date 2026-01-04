package org.ayaz.chatter.presentation

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.ayaz.chatter.presentation.plugins.installAuthentication
import org.ayaz.chatter.presentation.plugins.installContentNegotiation
import org.ayaz.chatter.presentation.plugins.installCors
import org.ayaz.chatter.presentation.plugins.installKoin
import org.ayaz.chatter.presentation.plugins.installLogging
import org.ayaz.chatter.presentation.plugins.installRouting
import org.ayaz.chatter.presentation.plugins.installStatusPages

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    installStatusPages()
    installKoin()
    installCors()
    installLogging()
    installContentNegotiation()
    installAuthentication()
    installRouting()
}