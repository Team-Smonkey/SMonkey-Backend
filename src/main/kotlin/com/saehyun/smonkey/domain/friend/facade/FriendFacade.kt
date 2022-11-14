package com.saehyun.smonkey.domain.friend.facade

import com.saehyun.smonkey.domain.friend.entity.Friend

interface FriendFacade {

    fun createFriend(friend: Friend)

    fun getBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Friend

    fun existsBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Boolean
}
