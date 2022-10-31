package com.saehyun.smonkey.domain.user.facade

import com.saehyun.smonkey.domain.user.entity.User
import com.saehyun.smonkey.domain.user.exception.UserNotFoundException
import com.saehyun.smonkey.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

/**
 * facade pattern in user
 *
 * @throws UserNotFoundException 유저를 찾을 수 없는 경우
 */
@Component
internal class UserFacadeImpl(
    private val userRepository: UserRepository,
): UserFacade {

    override fun getById(id: Long): User =
        userRepository.findByIdOrNull(id) ?: throw UserNotFoundException.EXCEPTION

    override fun getByAccountId(accountId: String): User =
        userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION

    override fun getCurrentUser(): User {
        val currentUserAccountId = getAuthenticationName()
        return getByAccountId(currentUserAccountId)
    }

    override fun getUserExist(accountId: String): Boolean {
        return userRepository.findByAccountId(accountId) != null
    }

    private fun getAuthenticationName(): String {
        return SecurityContextHolder.getContext().authentication.name
            ?: throw UserNotFoundException.EXCEPTION
    }
}