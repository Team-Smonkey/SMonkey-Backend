package com.saehyun.smonkey.domain.friend.controller

import com.saehyun.smonkey.domain.friend.payload.request.AcceptFriendRequest
import com.saehyun.smonkey.domain.friend.payload.request.FriendRequest
import com.saehyun.smonkey.domain.friend.payload.response.GetFriendResponse
import com.saehyun.smonkey.domain.friend.service.AcceptFriendService
import com.saehyun.smonkey.domain.friend.service.GetFriendService
import com.saehyun.smonkey.domain.friend.service.RequestFriendService
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/friend")
@RestController
class FriendController(
    private val requestFriendService: RequestFriendService,
    private val acceptFriendService: AcceptFriendService,
    private val getFriendService: GetFriendService,
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

    @PostMapping("/accept")
    fun acceptFriend(
        @RequestBody request: AcceptFriendRequest,
    ): BaseResponse<Unit> {
        return acceptFriendService.acceptFriend(
            request = request,
        )
    }

    @GetMapping
    fun getFriend(): BaseResponse<GetFriendResponse> {
        return getFriendService.getFriend()
    }
}
