package com.saehyun.smonkey.domain.smonkey.exception

import com.saehyun.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

/**
 * 스몽키가 이미 존재 할 경우
 *
 * @throws SMonkeyAlreadyExistException
 */
object SMonkeyAlreadyExistException : GlobalException(SMonkeyErrorCode.SMONKEY_ALREADY_EXIST) {
    val EXCEPTION = SMonkeyAlreadyExistException
}
