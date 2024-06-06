package com.shu.network.dto.profileDto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FriendsListingDto(
    val kind: String,
    val data: FriendsDto
)