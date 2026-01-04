package org.ayaz.chatter.presentation.plugins

import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.ayaz.chatter.presentation.routes.auth.authRoutes

fun Application.installRouting() {
    routing {
        authRoutes()
    }
}