package com.saehyun.smonkey.domain.friend.service

import com.saehyun.smonkey.domain.friend.payload.response.SearchFriendResponse
import com.saehyun.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.saehyun.smonkey.domain.smonkey.mapper.toLevel
import com.saehyun.smonkey.domain.smonkey.mapper.levelToNextMaxPoint
import com.saehyun.smonkey.domain.smonkey.mapper.toStep
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class SearchFriendService(
    private val userFacade: UserFacade,
    private val smonkeyFacade: SMonkeyFacade
) {

    fun searchFriend(
        name: String,
    ): BaseResponse<SearchFriendResponse> {

        val userList = userFacade.searchUser(
            name = name,
        )

        val response = SearchFriendResponse(
            userList = userList.map { friend ->

                val friendUser = userFacade.getById(friend.id)
                val smonkey = smonkeyFacade.getSMonkeyByIdWithDefault(friend.id)
                val point = smonkey.point
                val level = point.toLevel()

                SearchFriendResponse.User(
                    friendId = friend.id,
                    friendAccountId = friend.accountId,
                    userName = friendUser.name,
                    smonkeyName = smonkey.name,
                    backgroundColor = smonkey.backgroundColor,
                    step = level.toStep(),
                    point = point,
                    level = level,
                    nextPoint = point.levelToNextMaxPoint(),
                )
            }
        )

        return BaseResponse(
            status = 200,
            message = SEARCH_FRIEND_SUCCESS_MESSAGE,
            content = response,
        )
    }

    companion object {
        const val SEARCH_FRIEND_SUCCESS_MESSAGE = "success to search friend"
    }
}
