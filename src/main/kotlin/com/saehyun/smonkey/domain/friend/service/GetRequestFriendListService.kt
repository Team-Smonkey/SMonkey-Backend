package com.saehyun.smonkey.domain.friend.service

import com.saehyun.smonkey.domain.friend.facade.FriendFacade
import com.saehyun.smonkey.domain.friend.payload.response.GetRequestFriendListResponse
import com.saehyun.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.saehyun.smonkey.domain.smonkey.mapper.toLevel
import com.saehyun.smonkey.domain.smonkey.mapper.toNextPoint
import com.saehyun.smonkey.domain.smonkey.mapper.toStep
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class GetRequestFriendListService(
    private val userFacade: UserFacade,
    private val smonkeyFacade: SMonkeyFacade,
    private val friendFacade: FriendFacade,
) {

    fun getFriendRequestList(): BaseResponse<GetRequestFriendListResponse> {

        val user = userFacade.getCurrentUser()
        val friendList = friendFacade.getRequestFriendList(user.id)

        val response = GetRequestFriendListResponse(
            friendList = friendList.map { friend ->

                val friendUser = userFacade.getById(friend.id)
                val smonkey = smonkeyFacade.getSMonkeyById(friend.id)
                val point = smonkey.point
                val level = point.toLevel()

                GetRequestFriendListResponse.Friend(
                    friendId = friend.id,
                    userName = friendUser.name,
                    smonkeyName = smonkey.name,
                    backgroundColor = smonkey.backgroundColor,
                    step = level.toStep(),
                    point = point,
                    level = level,
                    nextPoint = point.toNextPoint(),
                )
            }
        )

        return BaseResponse(
            status = 200,
            message = GET_REQUEST_FRIEND_LIST_SUCCESS_MESSAGE,
            content = response,
        )
    }

    companion object {
        const val GET_REQUEST_FRIEND_LIST_SUCCESS_MESSAGE = "success to request friend list"
    }
}
