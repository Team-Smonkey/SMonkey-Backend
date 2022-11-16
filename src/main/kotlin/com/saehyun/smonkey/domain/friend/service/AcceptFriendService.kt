package com.saehyun.smonkey.domain.friend.service

import com.saehyun.smonkey.domain.friend.facade.FriendFacade
import com.saehyun.smonkey.domain.friend.utils.FriendStatus
import com.saehyun.smonkey.domain.friend.utils.isPending
import com.saehyun.smonkey.domain.user.facade.UserFacade
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AcceptFriendService(
    private val userFacade: UserFacade,
    private val friendFacade: FriendFacade,
) {

    @Transactional
    fun acceptFriend(
        friendId: Long,
    ): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()
        val sender = userFacade.getById(friendId)

        val friend = friendFacade.getBySenderIdAndReceiverId(
            senderId = sender.id,
            receiverId = user.id,
        )

        if (friend.receiver.id == user.id && friend.status.isPending()) {
            friend.updateStatus(
                status = FriendStatus.ACCEPTED,
            )
        }

        return BaseResponse(
            status = 200,
            message = ACCEPT_FRIEND_SUCCESS_MESSAGE,
            content = null,
        )
    }

    companion object {
        const val ACCEPT_FRIEND_SUCCESS_MESSAGE = "success to accept friend"
    }
}
