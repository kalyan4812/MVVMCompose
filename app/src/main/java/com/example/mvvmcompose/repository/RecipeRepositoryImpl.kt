package com.example.mvvmcompose.repository

import android.content.Context
import com.example.mvvmcompose.data.models.Reciepe
import com.example.mvvmcompose.data.models.RecipeNetworkModel
import com.example.mvvmcompose.data.responses.RecipeResponse
import com.example.mvvmcompose.data.source.RecipeDtoMapper
import com.example.mvvmcompose.data.source.RecipeSource
import com.example.mvvmcompose.fromJson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class RecipeRepositoryImpl(
    private val service: RecipeSource,
    private val mapper: RecipeDtoMapper,
    val context: Context
) :
    RecipeRepository {

    init {

        println("dcba repo size : " + pickFromLocalJson()?.size)
    }

    override suspend fun search(token: String, page: Int, query: String): List<Reciepe> {
        return mapper.toDomainList(
            pickFromLocalJson() ?: emptyList()
        )
    }

    override suspend fun get(token: String, id: Int): Reciepe {
        return mapper.mapToDomainModel(service.get(token, id))
    }

    private fun pickFromLocalJson(): List<RecipeNetworkModel>? {
        return getDefaultFirebaseItems().also {
            println("dcba repo intercept : "+it)
        }.fromJson<RecipeResponse>()?.recipes
    }

    private fun getDefaultFirebaseItems(): String? {
        try {

            val `is`: InputStream = context.assets.open("local_food_recipe_data.json")
            val reader = BufferedReader(InputStreamReader(`is`))
            val result = StringBuilder()
            var curLine: String?
            while (reader.readLine().also { curLine = it } != null) {
                result.append(curLine)
            }
            reader.close()
            return result.toString()
        } catch (e: IOException) {
            println("dcba repo exception : "+e.localizedMessage)
        }
        return ""
    }
}