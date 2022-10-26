package com.saehyun.smonkey.global.security.jwt

import com.saehyun.smonkey.global.security.auth.AuthDetailsService
import org.springframework.stereotype.Component

/**
 * JWT Token의 Generate 담당하는 [JwtTokenProvider]
 *
 */
@Component
class JwtTokenProvider(
    private val authDetailsService: AuthDetailsService,
//    private val jwtProperties: JwtProperties,
) {
    // TODO JwtProperties 작업 후 작업
}