package com.example.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: UnitConverterApp
 * Created by chukimmuoi on 20/08/2022.
 */
interface ConverterRepository {

    suspend fun insertResult(result: ConversionResult)

    suspend fun deleteResult(result: ConversionResult)

    suspend fun deleteAllResult()

    fun getSaveResults(): Flow<List<ConversionResult>>
}