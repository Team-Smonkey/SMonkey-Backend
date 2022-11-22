package com.saehyun.smonkey.domain.smonkey.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class SMonkey(
    userId: Long,
    name: String,
    backgroundColor: String,
    point: Int,
) {
    @Id
    var userId = userId
        protected set

    var name = name
        protected set

    var backgroundColor = backgroundColor
        protected set

    var point = point
        protected set

    fun updateColor(
        backgroundColor: String,
    ): SMonkey {
        this.backgroundColor = backgroundColor
        return this
    }

    fun updatePoint(
        point: Int,
    ): SMonkey {
        this.point = point
        return this
    }
}
