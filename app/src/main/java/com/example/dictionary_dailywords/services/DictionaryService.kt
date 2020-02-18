package com.example.dictionary_dailywords.services

import com.example.dictionary_dailywords.models.dictionary.ResultResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.Path

interface DictionaryService {

    @Headers(
        "app_id:8403e575",
        "app_key:ba8ebe495fe2212014bab299ea5c70c2")
    @GET("entries/en-us/{word}")
    fun getWord(@Path("word") word: String) : Call<ResultResponse>

}