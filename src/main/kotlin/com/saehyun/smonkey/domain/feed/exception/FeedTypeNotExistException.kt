package com.saehyun.smonkey.domain.feed.exception

import com.saehyun.smonkey.domain.feed.exception.error.FeedErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object FeedTypeNotExistException : GlobalException(FeedErrorCode.FEED_TYPE_NOT_EXIST) {
    val EXCEPTION = FeedTypeNotExistException
}
