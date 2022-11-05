package com.saehyun.smonkey.domain.smonkey.controller

import com.saehyun.smonkey.domain.smonkey.payload.request.MakeSMonkeyRequest
import com.saehyun.smonkey.domain.smonkey.payload.request.UpdateBackgroundColorRequest
import com.saehyun.smonkey.domain.smonkey.service.MakeSMonkeyService
import com.saehyun.smonkey.domain.smonkey.service.UpdateBackgroundColorService
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/smonkey")
@RestController
class SMonkeyController(
    private val makeSMonkeyService: MakeSMonkeyService,
    private val updateBackgroundColorService: UpdateBackgroundColorService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun makeSMonkey(
        @RequestBody request: MakeSMonkeyRequest,
    ): BaseResponse<Unit> {
        return makeSMonkeyService.makeSMonkey(
            request = request,
        )
    }

    @PatchMapping
    fun updateBackgroundColor(
        @RequestBody request: UpdateBackgroundColorRequest,
    ): BaseResponse<Unit> {
        return updateBackgroundColorService.updateBackgroundColorService(
            request = request,
        )
    }
}