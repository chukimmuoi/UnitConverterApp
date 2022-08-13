package com.example.unitconverterapp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun TopScreen(list: List<Conversion>) {
    val selectedConversion: MutableState<Conversion?> = remember {
        mutableStateOf(null)
    }
    val inputText: MutableState<String> = remember {
        mutableStateOf("")
    }
    val typedValue = remember {
        mutableStateOf("0.0")
    }

    ConversionMenu(list = list) {
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText) { input ->
            typedValue.value = input
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
        ResultBlock(
            message1 = message1,
            message2 = message2
        )
    }
}