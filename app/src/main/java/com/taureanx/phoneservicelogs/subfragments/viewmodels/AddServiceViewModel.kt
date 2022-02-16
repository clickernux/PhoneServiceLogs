package com.taureanx.phoneservicelogs.subfragments.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taureanx.phoneservicelogs.ServiceRepository
import com.taureanx.phoneservicelogs.model.ServiceData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddServiceViewModel: ViewModel() {
    private val serviceRepository = ServiceRepository.get()

    private var _serviceData = MutableLiveData<ServiceData?>()
    val serviceData: LiveData<ServiceData?> = _serviceData

    fun addNewService(newService: ServiceData){
        viewModelScope.launch(Dispatchers.IO){
            serviceRepository.addNewService(newService)
        }
    }

    fun getServiceData(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            val data = serviceRepository.getService(id)
            withContext(Dispatchers.Main){
                _serviceData.value = data
            }
        }
    }

    fun deleteServiceData(){
        viewModelScope.launch(Dispatchers.IO){
            serviceRepository.deleteServiceData(serviceData.value!!)
        }
    }

    fun updateServiceData(){
        viewModelScope.launch(Dispatchers.IO){
            serviceRepository.updateServiceData(serviceData.value!!)
        }
    }
}