package com.DO.dictionary_dailywords.models.quote

import com.google.gson.annotations.SerializedName

data class Quote(

    @SerializedName("quoteText")
    val quoteText : String,

    @SerializedName("quoteAuthor")
    val quoteAuthor : String

)