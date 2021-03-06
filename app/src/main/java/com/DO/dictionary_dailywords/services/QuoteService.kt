package com.DO.dictionary_dailywords.services

import com.DO.dictionary_dailywords.models.quote.Quote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QuoteService {

    @GET("quotes/random")
    fun getQuote() : Call<Quote>

}