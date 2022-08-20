package com.example.unitconverterapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: UnitConverterApp
 * Created by chukimmuoi on 20/08/2022.
 */
@Database(entities = [ConversionResult::class], version = 1)
abstract class ConverterDatabase: RoomDatabase() {

    abstract val converterDAO: ConverterDAO
}