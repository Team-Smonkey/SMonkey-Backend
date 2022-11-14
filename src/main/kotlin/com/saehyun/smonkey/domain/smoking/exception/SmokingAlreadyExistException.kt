package com.saehyun.smonkey.domain.smoking.exception

import com.saehyun.smonkey.domain.smoking.exception.error.SmokingErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object SmokingAlreadyExistException : GlobalException(SmokingErrorCode.SMOKING_ALREADY_EXIST) {
    val EXCEPTION = SmokingAlreadyExistException
}
