package com.saehyun.smonkey.domain.friend.controller

import com.saehyun.smonkey.domain.friend.payload.request.AcceptFriendRequest
import com.saehyun.smonkey.domain.friend.payload.request.FriendRequest
import com.saehyun.smonkey.domain.friend.payload.request.RefuseFriendRequest
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
        @RequestBody request: FriendRequest,
    ): BaseResponse<Unit> {
        return requestFriendService.requestFriend(
            request = request,
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
        @RequestBody request: AcceptFriendRequest,
    ): BaseResponse<Unit> {
        return acceptFriendService.acceptFriend(
            request = request,
        )
    }

    @PostMapping("/refuse")
    fun refuseFriend(
        @RequestBody request: RefuseFriendRequest,
    ): BaseResponse<Unit> {
        return refuseFriendService.refuseFriend(
            request = request,
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
