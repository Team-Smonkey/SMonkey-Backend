package com.saehyun.smonkey.domain.feed.exception

import com.saehyun.smonkey.domain.feed.exception.error.FeedErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object FeedNotFoundException : GlobalException(FeedErrorCode.POST_NOT_FOUND) {
    val EXCEPTION = FeedNotFoundException
}
