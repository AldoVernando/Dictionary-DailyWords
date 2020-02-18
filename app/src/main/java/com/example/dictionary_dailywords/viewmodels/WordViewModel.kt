package com.example.dictionary_dailywords.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary_dailywords.models.dictionary.ResultResponse
import com.example.dictionary_dailywords.services.DictionaryService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class WordViewModel : ViewModel() {

    var data = MutableLiveData<ResultResponse>()
    var word_data : String

    private val BASE_URL = "https://od-api.oxforddictionaries.com/api/v2/"

    private val random_word = listOf<String>("dictionary", "love", "learn", "book", "food",
        "key", "mobile phone", "bag", "king", "money")

    init {
        word_data = getRandomWord()
        getData(word_data)
    }

    fun getData(word : String){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Log.d("tag","retro")

        retrofit.create(DictionaryService::class.java).getWord(word).enqueue(object : Callback<ResultResponse> {
            override fun onFailure(call: Call<ResultResponse>, t: Throwable) {
                Log.d("tag",t.message.toString())
            }

            override fun onResponse(
                call: Call<ResultResponse>,
                response: Response<ResultResponse>
            ) {
                if(response.isSuccessful){
                    data.value = response.body()

                    Log.d("tag", data.value!!.results[0].lexicalEntries[0].entries[0].senses[0].definitions[0])
                }
                else
                    Log.d("tag","not success")
            }

        })
    }

    private fun getRandomWord() : String {
        return random_word.shuffled().take(1)[0]
    }

}