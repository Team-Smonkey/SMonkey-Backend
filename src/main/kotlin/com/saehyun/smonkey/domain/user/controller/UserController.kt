package com.saehyun.smonkey.domain.user.controller

import com.saehyun.smonkey.domain.user.payload.request.SignUpRequest
import com.saehyun.smonkey.domain.user.service.SignUpService
import com.saehyun.smonkey.global.payload.BaseResponse
import com.saehyun.smonkey.global.security.jwt.payload.TokenResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val signUpService: SignUpService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun signUpUser(
        @RequestBody request: SignUpRequest,
    ): BaseResponse<TokenResponse> {
        return signUpService.signUp(request)
    }
}