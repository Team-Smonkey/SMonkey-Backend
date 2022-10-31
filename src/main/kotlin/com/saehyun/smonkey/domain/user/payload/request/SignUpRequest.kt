package com.saehyun.smonkey.domain.user.payload.request

data class SignUpRequest(
    val accountId: String,
    val password: String,
    val name: String,
    val email: String,
    val age: Int,
)
