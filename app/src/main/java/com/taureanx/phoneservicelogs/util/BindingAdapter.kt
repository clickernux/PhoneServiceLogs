package com.taureanx.phoneservicelogs.util

import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.taureanx.phoneservicelogs.databinding.ServiceTableRowBinding
import com.taureanx.phoneservicelogs.model.ServiceData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@BindingAdapter("setFormattedDate")
fun formatDate(textView: TextView, date: Date?) {
    date?.let {
        textView.text = getFormattedDate(it)
    }
}

@BindingAdapter("setStatusText")
fun statusText(textView: TextView, status: Boolean){
    textView.text = if(status) "YES" else "NO"
}

@BindingAdapter("setNoDataVisibility")
fun showOrHideNoData(textView: TextView, data: List<ServiceData>?){
    if(data.isNullOrEmpty()){
        textView.visibility = View.VISIBLE
    }else{
        textView.visibility = View.GONE
    }
}

@BindingAdapter("setTableLayoutManager")
fun tableLayoutManager(tableLayout: TableLayout, serviceList: List<ServiceData>?){
    val myScope = CoroutineScope(Dispatchers.Main)
    val context = tableLayout.context
    if(serviceList.isNullOrEmpty()){
        tableLayout.visibility = View.GONE
    }else{

        serviceList.map { data ->
            myScope.launch {
                val myLayoutInflater = LayoutInflater.from(context)
                val tableRow = ServiceTableRowBinding.inflate(myLayoutInflater, tableLayout, false)
                tableRow.serviceData = data
                tableLayout.addView(tableRow.customTableRow)
                tableRow.customTableRow.setOnLongClickListener {
                    Toast.makeText(context, data.cusName, Toast.LENGTH_SHORT).show()
                    true
                }
            }
        }
    }
}