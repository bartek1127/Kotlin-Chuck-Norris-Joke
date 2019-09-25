package com.bartek.chucknorris

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("jokes/categories")
    fun getCategories(): Observable<List<String>>

    @GET("jokes/random")
    fun getJokes( @Query("category") category: String ): Call<Jokes>

}




