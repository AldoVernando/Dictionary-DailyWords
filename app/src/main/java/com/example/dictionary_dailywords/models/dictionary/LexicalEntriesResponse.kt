package com.example.dictionary_dailywords.models.dictionary

import com.google.gson.annotations.SerializedName

data class LexicalEntriesResponse (

    @SerializedName("lexicalEntries")
    val lexicalEntries: List<EntriesResponse>

)