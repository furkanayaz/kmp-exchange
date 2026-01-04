package org.ayaz.chatter.presentation.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.ayaz.chatter.data.di.DBModule
import org.ayaz.chatter.domain.di.DomainModule
import org.ayaz.chatter.presentation.di.PresentationModule
import org.koin.core.logger.Level
import org.koin.ksp.generated.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.installKoin() {
    install(Koin) {
        slf4jLogger(Level.DEBUG)
        modules(DBModule().module, DomainModule().module, PresentationModule().module)
    }
}