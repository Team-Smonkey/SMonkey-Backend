package com.saehyun.smonkey.global.exception.error

import com.saehyun.smonkey.global.exception.GlobalException

object UnexpectException : GlobalException(GlobalExceptionErrorCode.UNEXPECT) {
    val EXCEPTION = UnexpectException
}
