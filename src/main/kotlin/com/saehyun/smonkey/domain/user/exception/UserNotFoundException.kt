package com.saehyun.smonkey.domain.user.exception

import com.saehyun.smonkey.domain.user.exception.error.UserErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object UserNotFoundException: GlobalException(UserErrorCode.USER_NOT_FOUND) {
    val EXCEPTION = UserNotFoundException
}