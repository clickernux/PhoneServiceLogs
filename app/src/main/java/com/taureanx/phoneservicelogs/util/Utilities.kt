package com.taureanx.phoneservicelogs.util

import java.text.SimpleDateFormat
import java.util.*

enum class PhoneBrand{
    OPPO, VIVO, XIAOMI, HUAWEI, REALME, HONOR, TECNO, OTHER
}

fun getFormattedDate(date: Date): String{
    val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy EEE", Locale.getDefault())
    return simpleDateFormat.format(date).toString()
}