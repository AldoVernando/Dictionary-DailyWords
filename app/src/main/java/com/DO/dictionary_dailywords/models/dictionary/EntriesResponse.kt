package com.DO.dictionary_dailywords.models.dictionary

import com.google.gson.annotations.SerializedName

data class EntriesResponse (

    @SerializedName("entries")
    val entries: List<SensesResponse>

)