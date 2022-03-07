package com.example.readers.netwoek

import com.example.readers.data.BooksData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val BASE_URL = "https://www.googleapis.com"
private const val ENDPOINT = "/books/v1/volumes"
private const val DEFAULT = "search+terms&maxResults=40"
private const val API_KEY = "AIzaSyBlkY49AJ-dhEZCULByKv5Gh1C62WPicCE"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BookApiService{
    @GET(BASE_URL + ENDPOINT)
    suspend fun getBook(@Query("q") q : String = DEFAULT , @Query("key") key: String = API_KEY) : BooksData

}

object BooksApi {
    val retrofitService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }

}