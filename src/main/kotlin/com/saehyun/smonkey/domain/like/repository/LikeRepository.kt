package com.saehyun.smonkey.domain.like.repository

import com.saehyun.smonkey.domain.like.entity.FeedLike
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LikeRepository : CrudRepository<FeedLike, Long> {

    fun findByFeedId(feedId: Long): List<FeedLike>?

    fun findByUserId(userId: Long): List<FeedLike>

    fun findByFeedIdAndUserId(feedId: Long, userId: Long): FeedLike?
}
