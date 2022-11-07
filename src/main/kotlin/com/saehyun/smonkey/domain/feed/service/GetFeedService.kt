package com.saehyun.smonkey.domain.feed.service

import com.saehyun.smonkey.domain.feed.facade.FeedFacade
import com.saehyun.smonkey.domain.feed.payload.response.GetFeedResponse
import com.saehyun.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.saehyun.smonkey.domain.smonkey.mapper.toLevel
import com.saehyun.smonkey.domain.smonkey.mapper.toNextPoint
import com.saehyun.smonkey.domain.smonkey.mapper.toStep
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

/**
 * [TODO]
 * 좋아요 기능 완성 후 도입 필요
 */
@Service
class GetFeedService(
    private val feedFacade: FeedFacade,
    private val smonkeyFacade: SMonkeyFacade,
    private val userFacade: UserFacade,
) {

    fun getFeed(
        feedId: Long,
    ): BaseResponse<GetFeedResponse> {

        val feed = feedFacade.getFeedById(
            feedId = feedId,
        )

        val userId = feed.user.id

        val user = userFacade.getById(
            id = userId,
        )

        val smonkey = smonkeyFacade.getSMonkeyById(
            userId = userId,
        )

        val point = smonkey.point
        val level = point.toLevel()

        return BaseResponse(
            status = 200,
            message = GET_FEED_SUCCESS_MESSAGE,
            content = GetFeedResponse(
                writer = GetFeedResponse.Writer(
                    userName = user.name,
                    smonkeyName = smonkey.name,
                    backgroundColor = smonkey.backgroundColor,
                    step = level.toStep(),
                    point = point,
                    level = level,
                    nextPoint = point.toNextPoint(),
                ),
                feedId = feed.id,
                title = feed.title,
                content = feed.content,
                category = feed.category,
                createdAt = feed.createdAt!!,
            )
        )
    }

    companion object {
        const val GET_FEED_SUCCESS_MESSAGE = "success to get feed"
    }
}
