package org.ayaz.chatter.domain.use_cases.auth

import org.ayaz.chatter.data.dto_s.auth.LoginReqDTO
import org.ayaz.chatter.data.repositories.auth.LoginRepo
import org.koin.core.annotation.Single

@Single
class LoginUseCase(
    private val loginRepo: LoginRepo
) {
    suspend operator fun invoke(req: LoginReqDTO) = loginRepo.login(req)
}