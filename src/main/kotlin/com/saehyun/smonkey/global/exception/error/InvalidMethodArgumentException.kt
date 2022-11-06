package com.saehyun.smonkey.global.exception.error

import com.saehyun.smonkey.global.exception.GlobalException

object InvalidMethodArgumentException : GlobalException(GlobalExceptionErrorCode.INVALID_METHOD_ARGUMENT) {
    val EXCEPTION = InvalidMethodArgumentException
}
