package com.saehyun.smonkey.domain.feed.facade

import com.saehyun.smonkey.domain.feed.entity.Feed
import com.saehyun.smonkey.domain.feed.exception.FeedNotFoundException
import com.saehyun.smonkey.domain.feed.repository.FeedRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedFacadeImpl(
    private val feedRepository: FeedRepository,
): FeedFacade {

    override fun getFeed(feedId: Long): Feed {
        return feedRepository.findByIdOrNull(feedId) ?: throw FeedNotFoundException
    }

    override fun getFeedAll(): List<Feed> {
        return feedRepository.findAll()
    }

    override fun saveFeed(feed: Feed) {
        feedRepository.save(feed)
    }
}