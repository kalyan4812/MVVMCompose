package com.example.mvvmcompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun FoodCategoryChip(
    category: String, onSearch: () -> Unit,
    isSelected: Boolean = false,
    onSelectedCategoryChanged: (String) -> Unit,
) {
    Surface(
        modifier = Modifier.padding(end = 8.dp),
        shadowElevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.toggleable(value = isSelected, onValueChange = {
                onSelectedCategoryChanged(category)
                onSearch()
            })
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.bodyMedium,
                color = androidx.compose.ui.graphics.Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}