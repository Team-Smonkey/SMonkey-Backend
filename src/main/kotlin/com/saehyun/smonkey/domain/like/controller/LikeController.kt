package com.saehyun.smonkey.domain.like.controller

import com.saehyun.smonkey.domain.like.service.FeedLikeService
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/like")
@RestController
class LikeController(
    private val likeService: FeedLikeService
) {

    @PostMapping("/{feed-id}")
    fun like(
        @PathVariable("feed-id") feedId: Long,
    ): BaseResponse<Unit> {
        return likeService.like(
            feedId = feedId,
        )
    }

    @DeleteMapping("/{feed-id}")
    fun disLike(
        @PathVariable("feed-id") feedId: Long,
    ): BaseResponse<Unit> {
        return likeService.disLike(
            feedId = feedId,
        )
    }
}
