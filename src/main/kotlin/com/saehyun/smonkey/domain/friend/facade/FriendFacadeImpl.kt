package com.saehyun.smonkey.domain.friend.facade

import com.saehyun.smonkey.domain.friend.entity.Friend
import com.saehyun.smonkey.domain.friend.exception.FriendNotFoundException
import com.saehyun.smonkey.domain.friend.repository.FriendRepository
import com.saehyun.smonkey.domain.friend.utils.FriendStatus
import com.saehyun.smonkey.domain.user.entity.User
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

    override fun getFriendList(userId: Long): List<User> {

        val statuses = listOf(
            FriendStatus.ACCEPTED,
            FriendStatus.ACCEPTED_REVERSE,
        )

        val senderId: List<User> = friendRepository.getAllBySenderIdAndStatusIn(
            senderId = userId,
            statuses = statuses,
        ).map { it.receiver }

        val receiverId: List<User> = friendRepository.getAllByReceiverIdAndStatusIn(
            receiverId = userId,
            statuses = statuses,
        ).map { it.sender }

        val friendList = senderId.union(receiverId)

        return friendList.toList()
    }

}
