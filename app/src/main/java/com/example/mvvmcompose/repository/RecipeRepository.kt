package com.example.mvvmcompose.repository

import com.example.mvvmcompose.data.models.Reciepe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Reciepe>

    suspend fun get(token: String, id: Int): Reciepe

}