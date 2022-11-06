package com.saehyun.smonkey.domain.feed.payload.request

data class FeedRequest(
    val title: String,
    val content: String,
    val category: String,
)
