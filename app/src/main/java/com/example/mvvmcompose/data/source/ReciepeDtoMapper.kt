package com.example.mvvmcompose.data.source

import com.example.mvvmcompose.data.models.Reciepe
import com.example.mvvmcompose.data.models.RecipeNetworkModel
import com.example.mvvmcompose.utils.DomainMapper


class RecipeDtoMapper : DomainMapper<RecipeNetworkModel, Reciepe> {

    override fun mapToDomainModel(entity: RecipeNetworkModel): Reciepe {
        return Reciepe(
            id = entity.pk,
            title = entity.title,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.sourceUrl,
            description = entity.description,
            cookingInstructions = entity.cookingInstructions,
            ingredients = entity.ingredients ?: listOf(),
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated,
        )
    }

    override fun mapFromDomainModel(domainModel: Reciepe): RecipeNetworkModel {
        return RecipeNetworkModel(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
        )
    }

    fun toDomainList(initial: List<RecipeNetworkModel>): List<Reciepe> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Reciepe>): List<RecipeNetworkModel> {
        return initial.map { mapFromDomainModel(it) }
    }


}