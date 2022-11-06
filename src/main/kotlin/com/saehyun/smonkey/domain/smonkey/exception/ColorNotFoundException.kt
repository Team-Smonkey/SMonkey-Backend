package com.saehyun.smonkey.domain.smonkey.exception

import com.saehyun.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

/**
 * 색깔이 존재하지 않을 경우
 *
 * @throws ColorNotFoundException
 */
object ColorNotFoundException : GlobalException(SMonkeyErrorCode.COLOR_NOT_FOUND) {
    val EXCEPTION = ColorNotFoundException
}
