package com.saehyun.smonkey.global.exception

import com.saehyun.smonkey.global.exception.error.ErrorResponse

open class GlobalException(private val error: ErrorResponse) : RuntimeException() {
    val status: Int
        get() = error.status

    override val message: String
        get() = error.message
}
