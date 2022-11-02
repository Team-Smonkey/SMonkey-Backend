package com.saehyun.smonkey.domain.smonkey.payload

data class MakeSMonkeyRequest(
    val userId: Long,
    val name: String,
    val backgroundColor: String,
)
