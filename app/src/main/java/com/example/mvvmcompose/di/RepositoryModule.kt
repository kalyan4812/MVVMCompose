package com.example.mvvmcompose.di

import android.content.Context
import com.example.mvvmcompose.data.source.RecipeDtoMapper
import com.example.mvvmcompose.data.source.RecipeSource
import com.example.mvvmcompose.repository.RecipeRepository
import com.example.mvvmcompose.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeSource,
        recipeMapper: RecipeDtoMapper,@ApplicationContext context: Context
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService,
            mapper = recipeMapper,context
        )
    }
}