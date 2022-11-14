package com.saehyun.smonkey.domain.smoking.exception.error

import com.saehyun.smonkey.global.exception.error.ErrorResponse

enum class SmokingErrorCode(
    override val message: String,
    override val status: Int,
) : ErrorResponse {

    SMOKING_NOT_FOUND(
        message = "smoking info not found",
        status = 404,
    ),

    SMOKING_ALREADY_EXIST(
        message = "smoking already exist",
        status = 409,
    ),
}
