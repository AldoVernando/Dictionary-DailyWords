package com.DO.dictionary_dailywords.models.dictionary

import com.google.gson.annotations.SerializedName

data class ResultResponse(

    @SerializedName("results")
    val results: List<LexicalEntriesResponse>,

    @SerializedName("id")
    val id: String

)