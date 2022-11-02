package com.saehyun.smonkey.domain.smonkey.service

import com.saehyun.smonkey.domain.smonkey.entity.SMonkey
import com.saehyun.smonkey.domain.smonkey.exception.ColorNotFoundException
import com.saehyun.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.saehyun.smonkey.domain.smonkey.payload.MakeSMonkeyRequest
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

private const val DefaultPoint: Int = 0

private val colorList: List<String> = listOf(
    "WHITE",
    "BLACK",
)

@Service
class MakeSMonkeyService(
    private val sMonkeyFacade: SMonkeyFacade
) {

    fun makeSMonkey(
        request: MakeSMonkeyRequest
    ): BaseResponse<Unit> {
        if(
            colorList.none {
                it == request.backgroundColor
            }
        ) {
            throw ColorNotFoundException.EXCEPTION
        }

        sMonkeyFacade.saveSMonkey(
            SMonkey(
                userId = request.userId,
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