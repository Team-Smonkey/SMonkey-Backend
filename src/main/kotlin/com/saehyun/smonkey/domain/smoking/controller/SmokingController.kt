package com.saehyun.smonkey.domain.smoking.controller

import com.saehyun.smonkey.domain.smoking.payload.request.PostSmokingRequest
import com.saehyun.smonkey.domain.smoking.service.DeductedPointService
import com.saehyun.smonkey.domain.smoking.service.PostSmokingService
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/smoking")
@RestController
class SmokingController(
    private val postSmokingService: PostSmokingService,
    private val deductedPointService: DeductedPointService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postSmoking(
        @RequestBody request: PostSmokingRequest,
    ): BaseResponse<Unit> {
        return postSmokingService.postSmoking(
            request = request,
        )
    }

    @PostMapping("/failed")
    fun deductedPoint(): BaseResponse<Unit> {
        return deductedPointService.pointDeducted()
    }
}
