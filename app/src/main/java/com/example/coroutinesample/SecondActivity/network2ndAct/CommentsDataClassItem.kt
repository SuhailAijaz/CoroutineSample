package com.example.coroutinesample.SecondActivity.network2ndAct


import com.google.gson.annotations.SerializedName

data class CommentsDataClassItem(
    @SerializedName("body")
    val body: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("postId")
    val postId: Int = 0
)