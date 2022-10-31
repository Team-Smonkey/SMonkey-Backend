package com.saehyun.smonkey.domain.user.exception

import com.saehyun.smonkey.domain.user.exception.error.UserErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object PasswordNotCorrectException: GlobalException(UserErrorCode.PASSWORD_NOT_CORRECT) {
    val EXCEPTION = PasswordNotCorrectException
}