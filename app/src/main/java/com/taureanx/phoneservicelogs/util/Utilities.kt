package com.taureanx.phoneservicelogs.util

import java.text.SimpleDateFormat
import java.util.*

enum class PhoneBrand{
    OPPO, VIVO, XIAOMI, HUAWEI, REALME, HONOR, TECNO, OTHER
}

object DataSource{
    @JvmStatic
    val phoneBrand = listOf(
    PhoneBrand.XIAOMI.toString(),
    PhoneBrand.VIVO.toString(),
    PhoneBrand.OPPO.toString(),
    PhoneBrand.HONOR.toString(),
    PhoneBrand.HUAWEI.toString(),
    PhoneBrand.REALME.toString(),
    PhoneBrand.TECNO.toString(),
    PhoneBrand.OTHER.toString()
    )
}

fun getFormattedDate(date: Date): String{
    val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy EEE", Locale.getDefault())
    return simpleDateFormat.format(date).toString()
}