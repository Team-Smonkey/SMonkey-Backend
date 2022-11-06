package com.saehyun.smonkey.domain.smonkey.exception

import com.saehyun.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object SMonkeyNotFoundException : GlobalException(SMonkeyErrorCode.SMONKEY_NOT_FOUND) {
    val EXCEPTION = SMonkeyNotFoundException
}
