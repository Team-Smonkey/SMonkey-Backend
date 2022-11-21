package com.saehyun.smonkey.domain.feed.controller

import com.saehyun.smonkey.domain.feed.payload.request.SaveFeedRequest
import com.saehyun.smonkey.domain.feed.payload.request.UpdateFeedRequest
import com.saehyun.smonkey.domain.feed.payload.response.GetFeedListResponse
import com.saehyun.smonkey.domain.feed.payload.response.GetFeedResponse
import com.saehyun.smonkey.domain.feed.service.DeleteFeedService
import com.saehyun.smonkey.domain.feed.service.GetFeedService
import com.saehyun.smonkey.domain.feed.service.SaveFeedService
import com.saehyun.smonkey.domain.feed.service.UpdateFeedService
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/feed")
@RestController
class FeedController(
    private val saveFeedService: SaveFeedService,
    private val updateFeedService: UpdateFeedService,
    private val deleteFeedService: DeleteFeedService,
    private val getFeedService: GetFeedService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveFeed(
        @RequestParam("category") category: String,
        @RequestBody request: SaveFeedRequest,
    ): BaseResponse<Unit> {
        return saveFeedService.saveFeed(
            category = category,
            request = request,
        )
    }

    @PatchMapping("/{feed-id}/update")
    fun updateFeed(
        @PathVariable("feed-id") feedId: Long,
        @RequestParam("category") category: String,
        @RequestBody request: UpdateFeedRequest,
    ): BaseResponse<Unit> {
        return updateFeedService.updateFeed(
            feedId = feedId,
            category = category,
            request = request,
        )
    }

    @DeleteMapping("/{feed-id}")
    fun deleteFeed(
        @PathVariable("feed-id") feedId: Long,
    ): BaseResponse<Unit> {
        return deleteFeedService.deleteFeed(
            feedId = feedId,
        )
    }

    @GetMapping("/{feed-id}")
    fun getFeed(
        @PathVariable("feed-id") feedId: Long,
    ): BaseResponse<GetFeedResponse> {
        return getFeedService.getFeed(
            feedId = feedId,
        )
    }

    @GetMapping("/list")
    fun getFeedList(
        @RequestParam("category") category: String,
    ): BaseResponse<GetFeedListResponse> {
        return getFeedService.getFeedList(
            category = category,
        )
    }
}
