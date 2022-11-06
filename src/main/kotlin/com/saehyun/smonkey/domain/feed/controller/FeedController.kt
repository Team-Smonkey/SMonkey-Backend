package com.saehyun.smonkey.domain.feed.controller

import com.saehyun.smonkey.domain.feed.payload.request.FeedRequest
import com.saehyun.smonkey.domain.feed.service.SaveFeedService
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/feed")
@RestController
class FeedController(
    private val saveFeedService: SaveFeedService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveFeed(
        @RequestBody request: FeedRequest,
    ): BaseResponse<Unit> {
        return saveFeedService.saveFeed(
            request = request,
        )
    }
}