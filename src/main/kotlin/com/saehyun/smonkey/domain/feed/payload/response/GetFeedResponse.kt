package com.saehyun.smonkey.domain.feed.payload.response

import com.saehyun.smonkey.domain.feed.enum.FeedType
import java.time.LocalDateTime

data class GetFeedResponse(
    val writer: Writer,
    val feedId: Long,
    val title: String,
    val content: String,
    val likeCount: Int,
    val isLike: Boolean,
    val category: FeedType,
    val createdAt: LocalDateTime,
) {
    data class Writer(
        val userName: String,
        val smonkeyName: String,
        val backgroundColor: String,
        val step: Int,
        val point: Int,
        val level: Int,
        val nextPoint: Int,
    )
}
