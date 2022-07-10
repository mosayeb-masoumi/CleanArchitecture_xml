package com.example.cleanarchitecture_xml.data.remote.dto.get_list

import com.example.cleanarchitecture_xml.domain.model.user_list.UserItemModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserItemModelDto(
    @SerializedName("userId")
    @Expose
    val userId: Int,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("completed")
    @Expose
    val completed :Boolean
)


fun UserItemModelDto.toUserModelItem(): UserItemModel {

    return UserItemModel(
        userId = userId,
        id = id,
        title = title,
        completed = completed
    )
}


