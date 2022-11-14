package com.saehyun.smonkey.domain.friend.facade

import com.saehyun.smonkey.domain.friend.entity.Friend
import com.saehyun.smonkey.domain.friend.exception.FriendNotFoundException
import com.saehyun.smonkey.domain.friend.repository.FriendRepository
import org.springframework.stereotype.Component

@Component
class FriendFacadeImpl(
    private val friendRepository: FriendRepository,
): FriendFacade {

    override fun createFriend(
        friend: Friend,
    ) {
        friendRepository.save(friend)
    }

    override fun getBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Friend {
        return friendRepository.getBySenderIdAndReceiverId(
            senderId = senderId,
            receiverId = receiverId,
        ) ?: throw FriendNotFoundException
    }

    override fun existsBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Boolean {
        return friendRepository.existsBySenderIdAndReceiverId(
            senderId = senderId,
            receiverId = receiverId,
        )
    }

}
