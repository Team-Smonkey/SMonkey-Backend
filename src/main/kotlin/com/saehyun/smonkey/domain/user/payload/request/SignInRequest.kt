package com.saehyun.smonkey.domain.user.payload.request

data class SignInRequest(
    val accountId: String,
    val password: String,
)
