package com.saehyun.smonkey.domain.like.exception

import com.saehyun.smonkey.domain.like.exception.error.LikeErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object LikeAlreadyExistException : GlobalException(LikeErrorCode.LIKE_ALREADY_EXIST) {
    val EXCEPTION = LikeAlreadyExistException
}
