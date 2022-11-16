package com.saehyun.smonkey.domain.friend.controller

import com.saehyun.smonkey.domain.friend.payload.response.GetFriendResponse
import com.saehyun.smonkey.domain.friend.payload.response.GetRequestFriendListResponse
import com.saehyun.smonkey.domain.friend.payload.response.SearchFriendResponse
import com.saehyun.smonkey.domain.friend.service.*
import com.saehyun.smonkey.global.payload.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/friend")
@RestController
class FriendController(
    private val requestFriendService: RequestFriendService,
    private val acceptFriendService: AcceptFriendService,
    private val getFriendService: GetFriendService,
    private val refuseFriendService: RefuseFriendService,
    private val getRequestFriendListService: GetRequestFriendListService,
    private val searchFriendService: SearchFriendService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun requestFriend(
        @RequestParam("account-id") accountId: String,
    ): BaseResponse<Unit> {
        return requestFriendService.requestFriend(
            accountId = accountId,
        )
    }

    @GetMapping("/search")
    fun searchFriend(
        @RequestParam("name") name: String,
    ): BaseResponse<SearchFriendResponse> {
        return searchFriendService.searchFriend(
            name = name,
        )
    }

    @PostMapping("/accept")
    fun acceptFriend(
        @RequestParam("friend-id") friendId: Long,
    ): BaseResponse<Unit> {
        return acceptFriendService.acceptFriend(
            friendId = friendId,
        )
    }

    @PostMapping("/refuse")
    fun refuseFriend(
        @RequestParam("friend-id") friendId: Long,
    ): BaseResponse<Unit> {
        return refuseFriendService.refuseFriend(
            friendId = friendId,
        )
    }

    @GetMapping
    fun getFriend(): BaseResponse<GetFriendResponse> {
        return getFriendService.getFriend()
    }

    @GetMapping("/request")
    fun getRequestFriendList(): BaseResponse<GetRequestFriendListResponse> {
        return getRequestFriendListService.getFriendRequestList()
    }
}
