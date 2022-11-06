package com.saehyun.smonkey.domain.feed.facade

import com.saehyun.smonkey.domain.feed.entity.Feed

interface FeedFacade {

    fun getFeed(feedId: Long): Feed

    fun getFeedAll(): List<Feed>

    fun saveFeed(feed: Feed)
}
