package com.saehyun.smonkey.domain.smonkey.payload.response

data class GetSMonkeyResponse(
    val userName: String,
    val smonkeyName: String,
    val backgroundColor: String,
    val step: Int,
    val point: Int,
    val level: Int,
    val nextPoint: Int,
)
