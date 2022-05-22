package com.music.findcat.api

import com.music.findcat.FollowersList
import com.music.findcat.NewUserList
import com.music.findcat.User
import com.music.findcat.UserList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("users")
    fun getUserList(): Call<ArrayList<UserList>>

    @GET("users/{login}")
    fun getUser(
        @Path("login") login:String
    ):Call<User>

    @GET("users/{login}/followers")
    fun getFollowers(
        @Path("login") login:String
    ):Call<ArrayList<FollowersList>>


    @GET("users/{login}/subscriptions")
    fun getNewUser(
        @Path("login") login:String
    ):Call<ArrayList<NewUserList>>




    companion object{

        val BASE_URL = "https://api.github.com/"

        fun create(): Api {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}