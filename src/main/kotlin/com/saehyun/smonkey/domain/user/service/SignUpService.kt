package com.saehyun.smonkey.domain.user.service

import com.saehyun.smonkey.domain.user.entity.RefreshToken
import com.saehyun.smonkey.domain.user.entity.User
import com.saehyun.smonkey.domain.user.exception.UserAlreadyExistException
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.domain.user.payload.request.SignUpRequest
import com.saehyun.smonkey.domain.user.repository.RefreshTokenRepository
import com.saehyun.smonkey.domain.user.repository.UserRepository
import com.saehyun.smonkey.global.payload.BaseResponse
import com.saehyun.smonkey.global.security.jwt.JwtTokenProvider
import com.saehyun.smonkey.global.security.jwt.payload.TokenResponse
import com.saehyun.smonkey.global.security.properties.JwtProperties
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

private const val SIGN_UP_MESSAGE = "sign up success"

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder,
    private val userFacade: UserFacade,
    jwtProperties: JwtProperties,
) {
    private val refreshExp: Long = jwtProperties.refreshTokenExp

    fun signUp(request: SignUpRequest): BaseResponse<TokenResponse> {
        if (userFacade.getUserExist(request.accountId)) throw UserAlreadyExistException

        val user = User(
            accountId = request.accountId,
            password = passwordEncoder.encode(request.password),
            name = request.name,
            email = request.email,
            age = request.age,
        )

        userRepository.save(user)

        val tokenResponse = jwtTokenProvider.getToken(
            accountId = user.accountId,
        )

        val refreshToken = RefreshToken(
            accountId = request.accountId,
            token = tokenResponse.refreshToken,
            ttl = refreshExp,
        )

        refreshTokenRepository.save(refreshToken)

        return BaseResponse(
            status = 201,
            message = SIGN_UP_MESSAGE,
            content = tokenResponse,
        )
    }
}
