package com.taureanx.phoneservicelogs.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.taureanx.phoneservicelogs.R
import com.taureanx.phoneservicelogs.adapter.ServiceRecyclerAdapter
import com.taureanx.phoneservicelogs.model.ServiceData
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

@BindingAdapter("setDataToRecyclerView")
fun setUpRecyclerView(recyclerView: RecyclerView, data: List<ServiceData>?){
    val adapter = recyclerView.adapter as ServiceRecyclerAdapter
    data?.let {
        adapter.submitList(it)
    }
}

@BindingAdapter("setServiceStatus")
fun showStatusOfServiceDevice(imageView: ImageView, data: ServiceData){
    if(data.repaired && data.isTaken){
        imageView.visibility = View.VISIBLE
        imageView.setImageResource(R.drawable.ic_done_all)
    }else if (data.repaired){
        imageView.visibility = View.VISIBLE
        imageView.setImageResource(R.drawable.ic_done)
    }else{
        imageView.visibility = View.GONE
    }
}


@BindingAdapter("selectedBrand")
fun managePhoneBrand(autoCompleteTextView: MaterialAutoCompleteTextView, selectedBrand: String){
    autoCompleteTextView.setText(selectedBrand, false)
}
