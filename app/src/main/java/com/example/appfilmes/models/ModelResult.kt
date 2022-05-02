package com.example.appfilmes.models

import com.google.gson.annotations.SerializedName

data class ModelResult(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Any>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)