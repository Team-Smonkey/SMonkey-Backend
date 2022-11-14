package com.saehyun.smonkey.domain.friend.facade

import com.saehyun.smonkey.domain.friend.entity.Friend
import com.saehyun.smonkey.domain.user.entity.User

interface FriendFacade {

    fun createFriend(friend: Friend)

    fun refuseFriend(friend: Friend)

    fun getBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Friend

    fun existsBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Boolean

    fun getFriendList(
        userId: Long,
    ): List<User>

    fun getRequestFriendList(
        userId: Long,
    ): List<User>
}
