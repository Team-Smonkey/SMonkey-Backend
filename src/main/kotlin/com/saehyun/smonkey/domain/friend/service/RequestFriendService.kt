package com.saehyun.smonkey.domain.friend.service

import com.saehyun.smonkey.domain.friend.entity.Friend
import com.saehyun.smonkey.domain.friend.exception.CanNotAddMeFriendException
import com.saehyun.smonkey.domain.friend.exception.FriendAlreadyExistException
import com.saehyun.smonkey.domain.friend.facade.FriendFacade
import com.saehyun.smonkey.domain.friend.payload.request.FriendRequest
import com.saehyun.smonkey.domain.friend.utils.FriendStatus
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class RequestFriendService(
    private val friendFacade: FriendFacade,
    private val userFacade: UserFacade,
) {

    fun requestFriend(
        request: FriendRequest,
    ): BaseResponse<Unit> {

        val sender = userFacade.getCurrentUser()

        if(request.receiverId == sender.id) throw CanNotAddMeFriendException

        val receiver = userFacade.getById(
            id = request.receiverId,
        )

        friendFacade.existsBySenderIdAndReceiverId(
            senderId = sender.id,
            receiverId = receiver.id
        ).also {
            if(it) throw FriendAlreadyExistException
        }

        friendFacade.createFriend(
            Friend(
                sender = sender,
                receiver = receiver,
                status = FriendStatus.PENDING,
            )
        )

        return BaseResponse(
            status = 201,
            message = REQUEST_FRIEND_SUCCESS_MESSAGE,
            content = null,
        )
    }

    companion object {
        const val REQUEST_FRIEND_SUCCESS_MESSAGE = "success to request friend"
    }
}
