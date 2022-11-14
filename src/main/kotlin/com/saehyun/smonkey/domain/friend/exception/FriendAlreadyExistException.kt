package com.saehyun.smonkey.domain.friend.exception

import com.saehyun.smonkey.domain.friend.exception.error.FriendErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object FriendAlreadyExistException : GlobalException(FriendErrorCode.FRIEND_ALREADY_EXIST) {
    val EXCEPTION = FriendAlreadyExistException
}
