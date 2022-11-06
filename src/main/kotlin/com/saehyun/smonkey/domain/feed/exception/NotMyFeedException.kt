package com.saehyun.smonkey.domain.feed.exception

import com.saehyun.smonkey.domain.feed.exception.error.FeedErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object NotMyFeedException : GlobalException(FeedErrorCode.NOT_MY_FEED) {
    val EXCEPTION = NotMyFeedException
}
