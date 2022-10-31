package com.saehyun.smonkey.domain.user.exception

import com.saehyun.smonkey.domain.user.exception.error.UserErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object UserAlreadyExistException: GlobalException(UserErrorCode.USER_ALREADY_EXIST) {
    val EXCEPTION = UserAlreadyExistException
}