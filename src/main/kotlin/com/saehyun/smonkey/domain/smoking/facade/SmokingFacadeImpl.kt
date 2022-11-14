package com.saehyun.smonkey.domain.smoking.facade

import com.saehyun.smonkey.domain.smoking.entity.Smoking
import com.saehyun.smonkey.domain.smoking.exception.SmokingAlreadyExistException
import com.saehyun.smonkey.domain.smoking.exception.SmokingNotFoundException
import com.saehyun.smonkey.domain.smoking.repository.SmokingRepository
import org.springframework.stereotype.Component

@Component
class SmokingFacadeImpl(
    private val smokingRepository: SmokingRepository
) : SmokingFacade {

    override fun getSmokingByUserId(
        userId: Long,
    ): Smoking {
        return smokingRepository.findByUserId(
            userId = userId,
        ) ?: throw SmokingNotFoundException
    }

    override fun saveSmoking(smoking: Smoking) {
        if (smokingRepository.existsById(smoking.userId))
            throw SmokingAlreadyExistException

        smokingRepository.save(smoking)
    }
}
