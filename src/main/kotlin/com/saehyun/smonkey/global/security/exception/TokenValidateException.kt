package com.saehyun.smonkey.global.security.exception

import com.saehyun.smonkey.global.exception.GlobalException

/**
 * 토큰 검증을 실패했을 경우의 Exception
 *
 * @throws TokenValidateException
 */
object TokenValidateException: GlobalException(TokenErrorCode.TOKEN_VALIDATE_FAIL) {
    val EXCEPTION = TokenValidateException
}