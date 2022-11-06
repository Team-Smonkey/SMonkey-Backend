package com.saehyun.smonkey.domain.smonkey.exception

import com.saehyun.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object SmokingStepNotFoundException : GlobalException(SMonkeyErrorCode.SMOKING_STEP_NOT_FOUND) {
    val EXCEPTION = SmokingStepNotFoundException
}
