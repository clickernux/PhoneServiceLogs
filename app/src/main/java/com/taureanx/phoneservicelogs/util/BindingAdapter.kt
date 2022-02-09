package com.taureanx.phoneservicelogs.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.*

@BindingAdapter("setFormattedDate")
fun formatDate(textView: TextView, date: Date) {
    textView.text = getFormattedDate(date)
}