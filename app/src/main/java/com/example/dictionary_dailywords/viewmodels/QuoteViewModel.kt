package com.example.dictionary_dailywords.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary_dailywords.models.quote.Quote
import com.example.dictionary_dailywords.services.QuoteService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteViewModel : ViewModel(){

    var data = MutableLiveData<Quote>()

    private val BASE_URL = "https://quote-garden.herokuapp.com/"

    init {
        getData()
    }

    private fun getData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Log.d("tag","retro")

        retrofit.create(QuoteService::class.java).getQuote().enqueue(object :
            Callback<Quote> {
            override fun onFailure(call: Call<Quote>, t: Throwable) {
                Log.d("tag",t.message.toString())
            }

            override fun onResponse(
                call: Call<Quote>,
                response: Response<Quote>
            ) {
                if(response.isSuccessful){
                    data.value = response.body()
                }
                else
                    Log.d("tag","not success")
            }

        })
    }

}