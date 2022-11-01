package com.saehyun.smonkey.domain.user.service

import com.saehyun.smonkey.domain.user.entity.RefreshToken
import com.saehyun.smonkey.domain.user.exception.PasswordNotCorrectException
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.domain.user.payload.request.SignInRequest
import com.saehyun.smonkey.domain.user.repository.RefreshTokenRepository
import com.saehyun.smonkey.global.payload.BaseResponse
import com.saehyun.smonkey.global.security.jwt.JwtTokenProvider
import com.saehyun.smonkey.global.security.jwt.payload.TokenResponse
import com.saehyun.smonkey.global.security.properties.JwtProperties
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

private const val SIGN_IN_SUCCESS = "success to sign in"

@Service
class SignInService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    jwtProperties: JwtProperties,
) {
    private val refreshExp: Long = jwtProperties.refreshTokenExp

    fun signIn(
        request: SignInRequest,
    ): BaseResponse<TokenResponse> {

        val user = userFacade.getByAccountId(request.accountId)

        if(!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordNotCorrectException.EXCEPTION
        }

        val tokenResponse = jwtTokenProvider.getToken(
            accountId = request.accountId,
        )

        val refreshToken = RefreshToken(
            accountId = request.accountId,
            token = tokenResponse.refreshToken,
            ttl = refreshExp,
        )

        refreshTokenRepository.save(refreshToken)

        return BaseResponse(
            status = 200,
            message = SIGN_IN_SUCCESS,
            content = tokenResponse,
        )
    }
}