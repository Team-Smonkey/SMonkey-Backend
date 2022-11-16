package com.saehyun.smonkey.domain.user.facade

import com.saehyun.smonkey.domain.user.entity.User

interface UserFacade {
    fun getById(id: Long): User

    fun getByAccountId(accountId: String): User

    fun getCurrentUser(): User

    fun getUserExist(accountId: String): Boolean

    fun searchUser(name: String): List<User>
}
