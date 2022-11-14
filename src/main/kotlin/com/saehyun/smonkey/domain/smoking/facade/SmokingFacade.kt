package com.saehyun.smonkey.domain.smoking.facade

import com.saehyun.smonkey.domain.smoking.entity.Smoking

interface SmokingFacade {

    fun getSmokingByUserId(
        userId: Long,
    ): Smoking

    fun saveSmoking(
        smoking: Smoking,
    )
}
