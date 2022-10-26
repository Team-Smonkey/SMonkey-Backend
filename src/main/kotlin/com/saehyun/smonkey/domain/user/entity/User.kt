package com.saehyun.smonkey.domain.user.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * User의 기본적인 형태의 base class
 *
 * @param accountId 계정 아이디
 * @param password 계정 비밀번호
 * @param name 유저 이름(실명)
 * @param email 유저 이메일
 * @param age 유저 나이
 *
 * Lazy loading을 위해서 open class로 처리
 */
@Entity
class User(
    accountId: String,
    password: String,
    name: String,
    email: String,
    age: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    var accountId = accountId
        protected set

    var password = password
        protected set

    var name = name
        protected set

    var email = email
        protected set

    var age = age
        protected set
}