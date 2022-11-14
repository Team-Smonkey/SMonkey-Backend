package com.saehyun.smonkey.domain.friend.controller

import com.saehyun.smonkey.domain.friend.payload.request.FriendRequest
import com.saehyun.smonkey.domain.friend.service.RequestFriendService
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/friend")
@RestController
class FriendController(
    private val requestFriendService: RequestFriendService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun requestFriend(
        @RequestBody request: FriendRequest,
    ): BaseResponse<Unit> {
        return requestFriendService.requestFriend(
            request = request,
        )
    }
}
