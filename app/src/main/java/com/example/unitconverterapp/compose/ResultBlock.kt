package com.example.unitconverterapp.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: UnitConverterApp
 * Created by chukimmuoi on 13/08/2022.
 */
@Composable
fun ResultBlock(
    message1: String,
    message2: String,
    modifier: Modifier = Modifier
) {
    
    Card(
        elevation = 24.dp,
        modifier = modifier.padding(0.dp, 24.dp, 0.dp, 0.dp)
    ) {
        Column(modifier = modifier.padding(8.dp)) {
            Text(
                text = message1,
                fontSize = 28.sp
            )

            Text(
                text = message2,
                fontSize = 28.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
