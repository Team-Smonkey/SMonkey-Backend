package com.saehyun.smonkey.domain.friend.entity

import com.saehyun.smonkey.domain.friend.utils.FriendStatus
import com.saehyun.smonkey.domain.user.entity.User
import javax.persistence.*

@Entity
@Table(name = "friend")
data class Friend(

    @ManyToOne(
        fetch = FetchType.EAGER,
    )
    @JoinColumn(name = "sender_id")
    val sender: User,

    @ManyToOne(
        fetch = FetchType.EAGER,
    )
    @JoinColumn(name = "receiver_id")
    val receiver: User,

    var status: FriendStatus,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    fun updateStatus(status: FriendStatus) {
        this.status = status
    }
}
