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
class ConverterRepositoryImpl(
    private val dao: ConverterDAO
): ConverterRepository {

    override suspend fun insertResult(result: ConversionResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAllResult() {
        dao.deleteAll()
    }

    override fun getSaveResults(): Flow<List<ConversionResult>> {
        return dao.getResults()
    }
}