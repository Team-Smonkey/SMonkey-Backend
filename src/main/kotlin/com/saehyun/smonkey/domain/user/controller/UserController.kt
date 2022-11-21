package com.saehyun.smonkey.domain.user.controller

import com.saehyun.smonkey.domain.user.payload.request.SignInRequest
import com.saehyun.smonkey.domain.user.payload.request.SignUpRequest
import com.saehyun.smonkey.domain.user.service.SignInService
import com.saehyun.smonkey.domain.user.service.SignUpService
import com.saehyun.smonkey.global.payload.BaseResponse
import com.saehyun.smonkey.global.security.jwt.payload.TokenResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/user")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val signInService: SignInService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(
        @RequestBody request: SignUpRequest,
    ): BaseResponse<TokenResponse> {
        return signUpService.signUp(
            request = request,
        )
    }

    @PostMapping("/signin")
    fun signIn(
        @RequestBody request: SignInRequest,
    ): BaseResponse<TokenResponse> {
        return signInService.signIn(
            request = request,
        )
    }
}
