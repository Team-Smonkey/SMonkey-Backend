package com.saehyun.smonkey.domain.smonkey.facade

import com.saehyun.smonkey.domain.smonkey.entity.SMonkey
import com.saehyun.smonkey.domain.smonkey.exception.SMonkeyAlreadyExistException
import com.saehyun.smonkey.domain.smonkey.exception.SMonkeyNotFoundException
import com.saehyun.smonkey.domain.smonkey.repository.SMonkeyRepository
import org.springframework.stereotype.Component

@Component
internal class SMonkeyFacadeImpl(
    private val smonkeyRepository: SMonkeyRepository
) : SMonkeyFacade {

    override fun saveSMonkey(smonkey: SMonkey) {
        if (getSMonkeyExist(smonkey.userId)) throw SMonkeyAlreadyExistException

        smonkeyRepository.save(smonkey)
    }

    override fun getSMonkeyExist(userId: Long): Boolean {
        return smonkeyRepository.findByUserId(userId) != null
    }

    override fun getSMonkeyById(userId: Long): SMonkey {
        return smonkeyRepository.findByUserId(userId) ?: throw SMonkeyNotFoundException
    }

    override fun getSMonkeyByIdWithDefault(userId: Long): SMonkey {
        return smonkeyRepository.findByUserId(userId)
            ?: SMonkey(
                userId = userId,
                name = "no smonkey",
                backgroundColor = "WHITE",
                point = 0,
            )
    }
}
