package com.saehyun.smonkey.domain.smonkey.exception.error

import com.saehyun.smonkey.global.exception.error.ErrorResponse

enum class SMonkeyErrorCode(
    override val status: Int,
    override val message: String,
): ErrorResponse {

    /**
     * 존재하지 않는 색깔일 경
     */
    COLOR_NOT_FOUND(
        status = 401,
        message = "color not found"
    ),

    /**
     * 스몽키가 이미 존재 할 경우
     */
    SMONKEY_ALREADY_EXIST(
        status = 409,
        message = "smonkey already exist",
    )

}