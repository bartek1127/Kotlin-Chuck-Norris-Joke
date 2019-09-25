package com.bartek.chucknorris

import com.google.gson.annotations.SerializedName


data class Jokes(
    @SerializedName("value")
     val value: String
)