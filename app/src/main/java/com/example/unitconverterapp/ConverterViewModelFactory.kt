package com.example.unitconverterapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unitconverterapp.data.ConverterRepository

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: UnitConverterApp
 * Created by chukimmuoi on 20/08/2022.
 */
class ConverterViewModelFactory(private val repository: ConverterRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConverterViewModel(repository) as T
    }
}