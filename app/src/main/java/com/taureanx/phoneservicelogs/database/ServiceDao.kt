package com.taureanx.phoneservicelogs.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.taureanx.phoneservicelogs.model.ServiceData

@Dao
interface ServiceDao {

    @Query("SELECT * FROM service_data")
    fun getAll(): LiveData<List<ServiceData>>
}