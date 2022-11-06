package com.saehyun.smonkey.domain.feed.mapper

import com.saehyun.smonkey.domain.feed.enum.FeedType
import com.saehyun.smonkey.domain.feed.exception.FeedTypeNotExistException

internal fun String.toFeedType(): FeedType {

    for (feedType in FeedType.values()) {
        if (feedType.toString() == this) return feedType
    }

    throw FeedTypeNotExistException
}
