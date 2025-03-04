package com.example.kriptorep4ik.ui_components.screens.primary.primary_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kriptorep4ik.R
import com.example.kriptorep4ik.parse_data.ParserModel

@Composable
fun AllScreen(viewModelList: List<ParserModel>, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Курсы валют",
            style = TextStyle(fontWeight = FontWeight.Bold),
            color = Color.White,
            fontSize = 23.sp
        )
    }
}
@Composable
fun PanelItem(parserModel: ParserModel) {
    Card(
        modifier = Modifier.fillMaxWidth().wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.MainInterface),
            contentColor = colorResource(id = R.color.MainInterface),
            disabledContainerColor = colorResource(id = R.color.MainInterface),
            disabledContentColor = colorResource(id = R.color.MainInterface)
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = parserModel.currency,
            color = Color.White,
        )
        IconButton(
            onClick = {},

        ) {
            R.drawable.baseline_star_outline_24
        }
    }
}