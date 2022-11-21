package com.saehyun.smonkey.domain.smonkey.repository

import com.saehyun.smonkey.domain.smonkey.entity.SMonkey
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SMonkeyRepository : CrudRepository<SMonkey, Long> {
    fun findByUserId(userId: Long): SMonkey?
}
