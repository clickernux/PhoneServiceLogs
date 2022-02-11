package com.taureanx.phoneservicelogs.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.taureanx.phoneservicelogs.model.ServiceData

@Database(entities = [ServiceData::class], version = 1)
@TypeConverters(DataTypeConverter::class)
abstract class ServiceDatabase: RoomDatabase() {

    abstract fun serviceDao(): ServiceDao
}