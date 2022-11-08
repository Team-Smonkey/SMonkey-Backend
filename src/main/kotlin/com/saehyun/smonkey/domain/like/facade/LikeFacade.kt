package com.saehyun.smonkey.domain.like.facade

import com.saehyun.smonkey.domain.feed.entity.Feed
import com.saehyun.smonkey.domain.like.entity.FeedLike

interface LikeFacade {

    fun checkLikeAlready(
        userId: Long,
        feedId: Long,
    ): Boolean

    fun getLikeCount(feed: Feed): Int

    fun like(feedLike: FeedLike)

    fun disLike(feedLike: FeedLike)
}
