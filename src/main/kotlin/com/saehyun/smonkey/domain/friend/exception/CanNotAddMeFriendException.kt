package com.saehyun.smonkey.domain.friend.exception

import com.saehyun.smonkey.domain.friend.exception.error.FriendErrorCode
import com.saehyun.smonkey.global.exception.GlobalException

object CanNotAddMeFriendException : GlobalException(FriendErrorCode.CAN_NOT_ADD_ME_FRIEND) {
    val EXCEPTION = CanNotAddMeFriendException
}
