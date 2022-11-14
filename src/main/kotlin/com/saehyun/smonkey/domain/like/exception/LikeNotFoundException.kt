package com.saehyun.smonkey.domain.like.exception

import com.saehyun.smonkey.domain.like.exception.error.LikeErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object LikeNotFoundException : GlobalException(LikeErrorCode.LIKE_NOT_FOUND) {
    val EXCEPTION = LikeNotFoundException
}
