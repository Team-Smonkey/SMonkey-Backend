package com.saehyun.smonkey.global.security.exception

import com.saehyun.smonkey.global.exception.GlobalException

/**
 * 토큰이 만료됬을 경우의 Exception
 *
 * @exception TokenExpiredException
 */
object TokenExpiredException : GlobalException(TokenErrorCode.TOKEN_EXPIRED) {
    val EXCEPTION = TokenExpiredException
}
