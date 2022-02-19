package com.taureanx.phoneservicelogs.dialog_fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taureanx.phoneservicelogs.ServiceRepository
import com.taureanx.phoneservicelogs.model.ServiceData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DialogViewModel: ViewModel() {
    private val serviceRepository = ServiceRepository.get()
    private var _serviceData = MutableLiveData<ServiceData?>()
    val serviceData: LiveData<ServiceData?> = _serviceData

    fun getServiceData(itemId: Long?){
        itemId?.let {
            viewModelScope.launch(Dispatchers.IO){
                val data = serviceRepository.getService(it)
                withContext(Dispatchers.Main){
                    _serviceData.value = data
                }
            }
        }
    }

    fun startServiceActivity(myFun: (Long) -> Unit){
        myFun(serviceData.value?.id!!)
    }
}