package com.saehyun.smonkey.domain.friend.utils

enum class FriendStatus {
    PENDING,
    ACCEPTED,
    REFUSED,
    ACCEPTED_REVERSE;
}

internal fun FriendStatus.isPending() =
    this == FriendStatus.PENDING
