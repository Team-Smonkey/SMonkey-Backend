package com.saehyun.smonkey.domain.user.repository

import com.saehyun.smonkey.domain.user.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long> {
    fun findByAccountId(accountId: String): User?
}