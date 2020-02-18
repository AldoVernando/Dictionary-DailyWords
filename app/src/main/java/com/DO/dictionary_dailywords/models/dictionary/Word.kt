package com.DO.dictionary_dailywords.models.dictionary

import com.google.gson.annotations.SerializedName

data class Word(

    @SerializedName("definitions")
    val definitions : List<String>

)