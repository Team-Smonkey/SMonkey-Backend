package com.saehyun.smonkey.global.exception.error

enum class GlobalExceptionErrorCode(
        override val status: Int,
        override val message: String
): ErrorResponse {

    INVALID_METHOD_ARGUMENT(400, "Invalid Method Argument")
}