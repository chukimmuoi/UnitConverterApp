package com.example.unitconverterapp.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverterapp.ConverterViewModel
import com.example.unitconverterapp.ConverterViewModelFactory
import com.example.unitconverterapp.compose.converter.TopScreen
import com.example.unitconverterapp.compose.history.HistoryScreen

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
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
) {
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultList.collectAsState(initial = emptyList())

    val configuration = LocalConfiguration.current
    var isLandScape by remember { mutableStateOf(false) }

    when(configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandScape = true
            Row(
                modifier = modifier
                    .padding(32.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TopScreen(
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue,
                    isLandScape,
                ) { message1, message2 ->
                    converterViewModel.addResult(message1, message2)
                }
                Spacer(modifier = modifier.width(8.dp))
                HistoryScreen(
                    historyList,
                    onCloseTask = {
                        converterViewModel.removeResult(it)
                    },
                    onClearAllTask = {
                        converterViewModel.clearAll()
                    }
                )
            }
        }
        else -> {
            isLandScape = false
            Column(modifier = modifier.padding(32.dp)) {
                TopScreen(
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue,
                    isLandScape,
                ) { message1, message2 ->
                    converterViewModel.addResult(message1, message2)
                }
                Spacer(modifier = modifier.height(16.dp))
                HistoryScreen(
                    historyList,
                    onCloseTask = {
                        converterViewModel.removeResult(it)
                    },
                    onClearAllTask = {
                        converterViewModel.clearAll()
                    }
                )
            }
        }
    }
}