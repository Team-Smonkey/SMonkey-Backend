package com.saehyun.smonkey.domain.smonkey.service

import com.saehyun.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.saehyun.smonkey.domain.smonkey.mapper.toLevel
import com.saehyun.smonkey.domain.smonkey.mapper.toNextPoint
import com.saehyun.smonkey.domain.smonkey.mapper.toStep
import com.saehyun.smonkey.domain.smonkey.payload.response.GetSMonkeyResponse
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class GetSMonkeyService(
    private val sMonkeyFacade: SMonkeyFacade,
    private val userFacade: UserFacade,
) {

    fun getMonkey(): BaseResponse<GetSMonkeyResponse> {
        val user = userFacade.getCurrentUser()
        val smonkey = sMonkeyFacade.getSMonkeyById(
            userId = user.id,
        )

        val level = smonkey.point.toLevel()
        val nextPoint = smonkey.point.toNextPoint()
        val step = level.toStep()

        val getSMonkeyResponse =  GetSMonkeyResponse(
            userName = user.name,
            smonkeyName = smonkey.name,
            backgroundColor = smonkey.backgroundColor,
            level = level,
            step = step,
            point = smonkey.point,
            nextPoint = nextPoint,
        )

        return BaseResponse(
            status = 201,
            message = GetSMonkeySuccessMessage,
            content = getSMonkeyResponse,
        )
    }

    companion object {
        const val GetSMonkeySuccessMessage = "success to get smonkey"
    }
}