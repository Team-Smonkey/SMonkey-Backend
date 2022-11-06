package com.saehyun.smonkey.domain.user.exception

import com.saehyun.smonkey.domain.user.exception.error.UserErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

/**
 * 패스워드가 일치하지 않았을 경우 발생하는 [Exception]
 *
 * @throws PasswordNotCorrectException
 */
object PasswordNotCorrectException : GlobalException(UserErrorCode.PASSWORD_NOT_CORRECT) {
    val EXCEPTION = PasswordNotCorrectException
}
