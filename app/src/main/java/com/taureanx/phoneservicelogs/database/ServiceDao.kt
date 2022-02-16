package com.taureanx.phoneservicelogs.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.taureanx.phoneservicelogs.model.ServiceData

@Dao
interface ServiceDao {

    @Query("SELECT * FROM service_data")
    fun getAll(): LiveData<List<ServiceData>>

    @Insert
    fun addNewService(newService: ServiceData)

    @Query("SELECT * FROM SERVICE_DATA WHERE id=(:id)")
    fun getService(id: Long): ServiceData?

    @Update
    fun updateServiceData(serviceData: ServiceData)

    @Delete
    fun deleteServiceData(serviceData: ServiceData)
}