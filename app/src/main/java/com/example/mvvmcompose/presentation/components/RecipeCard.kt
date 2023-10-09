package com.example.mvvmcompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.mvvmcompose.R
import com.example.mvvmcompose.data.models.Reciepe


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecipeCard(reciepe: Reciepe, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .clickable {
                onClick.invoke()
            },
        elevation = CardDefaults.elevatedCardElevation(),
        shape = MaterialTheme.shapes.small
    ) {
        Column {
            reciepe.featuredImage.takeIf { it.isNullOrBlank().not() }?.let { url ->
                GlideImage(
                    model = url, contentDescription = "image",
                    modifier = Modifier.fillMaxSize().height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            reciepe.title.takeIf { it.isNullOrBlank().not() }?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp
                        )
                ) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.headlineMedium
                    )

                    val rank = reciepe.rating.toString()
                    Text(
                        text = rank,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }


}