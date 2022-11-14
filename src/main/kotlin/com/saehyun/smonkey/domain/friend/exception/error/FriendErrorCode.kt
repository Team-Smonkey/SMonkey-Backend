package com.saehyun.smonkey.domain.friend.exception.error

import com.saehyun.smonkey.global.exception.error.ErrorResponse

enum class FriendErrorCode(
    override val message: String,
    override val status: Int,
): ErrorResponse {

    /**
     * 이미 친구이거나 신청을 보냈을 경우
     */
    FRIEND_ALREADY_EXIST(
        message = "friend already exist or you've sent a request",
        status = 409,
    ),

    /**
     * 친구를 찾을 수 없음
     */
    FRIEND_NOT_FOUND(
        message = "friend not found",
        status = 404,
    ),


}