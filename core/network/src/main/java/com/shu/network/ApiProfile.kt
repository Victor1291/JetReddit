package com.shu.network

import com.shu.network.dto.postDto.SinglePostListingDto
import com.shu.network.dto.profileDto.ClickedUserProfileDto
import com.shu.network.dto.profileDto.FriendsListingDto
import com.shu.network.dto.profileDto.ProfileDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiProfile {

    @GET("/api/v1/me")
    suspend fun getLoggedUserProfile(): ProfileDto

    @GET("/api/v1/me/friends")
    suspend fun getFriends(): FriendsListingDto

    @GET("/user/{username}/about")
    suspend fun getAnotherUserProfile(
        @Path("username") username: String
    ): ClickedUserProfileDto

    @PUT("/api/v1/me/friends/{username}")
    suspend fun makeFriends(
        @Path("username") username: String,
        @Body requestBody: String = "{\"name\": \"$username\"}"
    )

    @GET("/user/{username}")
    suspend fun getUserContent(
        @Path("username") username: String
    ): SinglePostListingDto

/** no unfriend feature in tech.reqs, can add later*/
//    DELETE /api/v1/me/friends/usernamesubscribe
//    Stop being friends with a user.
}