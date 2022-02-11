package com.taureanx.phoneservicelogs.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
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