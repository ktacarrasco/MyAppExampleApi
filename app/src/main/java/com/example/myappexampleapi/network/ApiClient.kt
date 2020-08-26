package com.example.myappexampleapi.network

import com.example.myappexampleapi.pojo.Post
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("post/")
    fun groupList() : Call<List<Post>>

    @DELETE("/posts/{postId}")
    fun deletePost(@Path("postId")postId: Int?):Call<Void>




}