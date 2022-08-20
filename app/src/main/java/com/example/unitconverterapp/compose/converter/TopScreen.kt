package com.example.unitconverterapp.compose.converter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.unitconverterapp.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

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
fun TopScreen(
    list: List<Conversion>,
    selectedConversion: MutableState<Conversion?>,
    inputText: MutableState<String>,
    typedValue: MutableState<String>,
    isLandScape: Boolean,
    save: (String, String) -> Unit
) {
    var toSave by remember {
        mutableStateOf(false)
    }
    
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        ConversionMenu(
            list = list,
            isLandScape = isLandScape
        ) {
            selectedConversion.value = it
            typedValue.value = "0.0"
        }

        selectedConversion.value?.let {
            InputBlock(
                conversion = it,
                inputText = inputText,
                isLandScape = isLandScape
            ) { input ->
                typedValue.value = input
                toSave = true
            }
        }

        if (typedValue.value != "0.0") {
            val input = typedValue.value.toDouble()
            val multiply = selectedConversion.value?.multiplyBy ?: 0.0
            val result = input * multiply

            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            val roundedResult = df.format(result)

            val message1 = "${typedValue.value} ${selectedConversion.value?.convertFrom} is equal to"
            val message2 = "$roundedResult ${selectedConversion.value?.convertTo}"
            if (toSave) {
                save(message1, message2)
                toSave = false
            }
            ResultBlock(
                message1 = message1,
                message2 = message2
            )
        }
    }
}