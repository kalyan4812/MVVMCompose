package com.example.mvvmcompose.data.responses

import com.example.mvvmcompose.data.models.RecipeNetworkModel
import com.google.gson.annotations.SerializedName


data class RecipeResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeNetworkModel>,
)