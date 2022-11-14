package com.saehyun.smonkey.domain.smoking.exception

import com.saehyun.smonkey.domain.smoking.exception.error.SmokingErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object SmokingNotFoundException : GlobalException(SmokingErrorCode.SMOKING_NOT_FOUND) {
    val EXCEPTION = SmokingNotFoundException
}
