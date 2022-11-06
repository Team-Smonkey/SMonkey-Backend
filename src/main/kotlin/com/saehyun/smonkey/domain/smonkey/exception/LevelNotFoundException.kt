package com.saehyun.smonkey.domain.smonkey.exception

import com.saehyun.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object LevelNotFoundException : GlobalException(SMonkeyErrorCode.LEVEL_NOT_FOUND) {
    val EXCEPTION = LevelNotFoundException
}
