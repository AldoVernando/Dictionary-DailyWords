package com.example.dictionary_dailywords.models.dictionary

import com.google.gson.annotations.SerializedName

data class SensesResponse (

    @SerializedName("senses")
    val senses: List<Word>

)