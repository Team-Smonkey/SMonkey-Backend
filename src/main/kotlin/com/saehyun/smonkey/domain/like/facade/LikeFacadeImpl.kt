package com.saehyun.smonkey.domain.like.facade

import com.saehyun.smonkey.domain.feed.entity.Feed
import com.saehyun.smonkey.domain.like.entity.FeedLike
import com.saehyun.smonkey.domain.like.exception.LikeAlreadyExistException
import com.saehyun.smonkey.domain.like.exception.LikeNotFoundException
import com.saehyun.smonkey.domain.like.repository.LikeRepository
import org.springframework.stereotype.Component

@Component
class LikeFacadeImpl(
    private val likeRepository: LikeRepository,
): LikeFacade {

    override fun checkLikeAlready(feed: Feed): Boolean {
        TODO("Not yet implemented")
    }

    override fun getLikeCount(feed: Feed): Int {
        TODO("Not yet implemented")
    }

    override fun like(feedLike: FeedLike) {
       val like: FeedLike? = likeRepository.findByFeedIdAndUserId(
            feedId = feedLike.feed.id,
            userId = feedLike.user.id,
        )

        if(like == null) {
            likeRepository.save(feedLike)
        } else {
            throw LikeAlreadyExistException
        }
    }

    override fun disLike(feedLike: FeedLike) {
        val like: FeedLike? = likeRepository.findByFeedIdAndUserId(
            feedId = feedLike.feed.id,
            userId = feedLike.user.id,
        )

        if(like != null) {
            likeRepository.deleteById(like.id)
        } else {
            throw LikeNotFoundException
        }
    }
}
