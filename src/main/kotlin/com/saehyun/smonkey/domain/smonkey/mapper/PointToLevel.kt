package com.saehyun.smonkey.domain.smonkey.mapper

import com.saehyun.smonkey.domain.smonkey.exception.LevelNotFoundException
import com.saehyun.smonkey.domain.smonkey.utils.SMonkeyLevel

internal fun Int.toLevel(): Int {
    SMonkeyLevel.reversed().forEachIndexed { index, level ->
        if(this >= level.targetPoint) {
            return level.level
        }
    }

    throw LevelNotFoundException.EXCEPTION
}

internal fun Int.toNextPoint(): Int {
    return SMonkeyLevel[this.toLevel()].targetPoint
}