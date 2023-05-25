package com.example.hw3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixApi {
    @GET("api/")
    fun searchImage(
        @Query("q") keyword: String,
        @Query("key") key: String = "12507401-8addb696eb7df0fa73e07e39a"
    ):Call<PixabayModel>
}
