package com.saehyun.smonkey.domain.smonkey.service

import com.saehyun.smonkey.domain.smonkey.entity.SMonkey
import com.saehyun.smonkey.domain.smonkey.exception.ColorNotFoundException
import com.saehyun.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.saehyun.smonkey.domain.smonkey.payload.request.MakeSMonkeyRequest
import com.saehyun.smonkey.domain.smonkey.utils.DefaultPoint
import com.saehyun.smonkey.domain.smonkey.utils.colorList
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class MakeSMonkeyService(
    private val sMonkeyFacade: SMonkeyFacade,
    private val userFacade: UserFacade,
) {

    fun makeSMonkey(
        request: MakeSMonkeyRequest
    ): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()

        if (
            colorList.none {
                it == request.backgroundColor
            }
        ) {
            throw ColorNotFoundException.EXCEPTION
        }

        sMonkeyFacade.saveSMonkey(
            SMonkey(
                userId = user.id,
                name = request.name,
                backgroundColor = request.backgroundColor,
                point = DefaultPoint,
            )
        )

        return BaseResponse(
            status = 201,
            message = "success to make smonkey",
            content = null,
        )
    }
}
