package org.ayaz.spx500.domain.use_cases.user

import org.ayaz.spx500.data.repositories.user.IUserGetUuidRepo

class GetUuidUseCase(
    private val getUuidRepo: IUserGetUuidRepo
) {
    operator fun invoke(email: String?) = getUuidRepo.getUuid(email)
}