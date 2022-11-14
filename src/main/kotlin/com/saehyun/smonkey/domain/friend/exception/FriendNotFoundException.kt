package com.saehyun.smonkey.domain.friend.exception

import com.saehyun.smonkey.domain.friend.exception.error.FriendErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object FriendNotFoundException: GlobalException(FriendErrorCode.FRIEND_NOT_FOUND) {
    val EXCEPTION = FriendNotFoundException
}
