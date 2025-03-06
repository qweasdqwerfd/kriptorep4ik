package com.example.kriptorep4ik.ui_components.screens.primary.primary_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.ParserModel

@Composable
fun AllScreen(viewModelList: List<ParserModel>) {
    val favoriteItems = remember { mutableListOf<ParserModel>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn {
            items(viewModelList) { item ->
                PanelItemAll(
                    parserModel = item,
                    isFavorite = favoriteItems.contains(item),
                    onFavoriteClick = {
                        if (favoriteItems.contains(item)) {
                            favoriteItems.remove(item)
                        } else {
                            favoriteItems.add(item)
                        }
                    }
                )
            }
        }

    }

}

@Composable
fun PanelItemAll(
    parserModel: ParserModel,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.MainInterface),
            contentColor = colorResource(id = R.color.MainInterface)
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f), // Растягиваем текст, чтобы занял доступное место
                text = parserModel.currency,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )

            IconButton(onClick = onFavoriteClick) {
                Icon(
                    modifier = Modifier
                        .size(43.dp)
                        .padding(end = 10.dp),
                    painter = painterResource(
                        if (isFavorite) R.drawable.baseline_star_rate_24
                        else R.drawable.baseline_star_outline_24
                    ),
                    contentDescription = "star",
                    tint = Color.Black
                )
            }
        }
    }
}
