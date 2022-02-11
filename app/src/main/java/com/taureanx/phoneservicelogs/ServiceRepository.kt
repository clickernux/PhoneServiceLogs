package com.taureanx.phoneservicelogs

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.taureanx.phoneservicelogs.database.ServiceDatabase
import com.taureanx.phoneservicelogs.model.ServiceData

private const val DATABASE_NAME = "service-database"
class ServiceRepository private constructor(context: Context){

    private val database = Room.databaseBuilder(
        context.applicationContext,
        ServiceDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.serviceDao()

    fun getServices(): LiveData<List<ServiceData>> = crimeDao.getAll()

    companion object{
        private var INSTANCE: ServiceRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = ServiceRepository(context)
            }
        }

        fun get(): ServiceRepository{
            return INSTANCE ?: throw IllegalStateException("ServiceRepository must be initialized!!")
        }
    }
}