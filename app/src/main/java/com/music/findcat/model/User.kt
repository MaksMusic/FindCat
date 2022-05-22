package com.music.findcat

import com.google.gson.annotations.SerializedName

data class UserList(
    @SerializedName("login")
    var login:String,
    @SerializedName("avatar_url")
    var avatarUrl:String
)


data class NewUserList(
    @SerializedName("name")
    var name :String,
    @SerializedName("avatar_url")
    var avatarUrl:String,
    @SerializedName("node_id")
    var textInfo:String,
    @SerializedName("owner")
    var owner:Owner,

)

data class User (
    @SerializedName("login")
    var login:String,
    @SerializedName("avatar_url")
    var avatarUrl:String,
    @SerializedName("followers_url")
    var followersUrl :String,
    @SerializedName("following_url")
    var followingUrl :String,
    @SerializedName("id")
    var id :Int,
    @SerializedName(" site_admin")
    var site_admin :Boolean,
)

data class Owner(
    @SerializedName("login")
    var login:String,
    @SerializedName("avatar_url")
    var avatarUrl:String,
    @SerializedName("id")
    var id :Int,

)

data class FollowersList(
    @SerializedName("login")
    var login:String,
    @SerializedName("avatar_url")
    var avatarUrl:String
)