package com.taureanx.phoneservicelogs.model

import com.taureanx.phoneservicelogs.util.PhoneBrand
import java.util.*

data class ServiceData(
    var cusName: String = "",
    var collectedDate: Date = Date(),
    var phBrand: PhoneBrand,
    var phModel: String = "",
    var case: String = "",
    var urgent: Boolean = false,
    var repaired: Boolean = false,
    var isTaken: Boolean = false,
    var takenDate: Date? = null
)

object DummyData{
    val data = listOf(
        ServiceData(
            cusName = "ထွန်းထွန်းနိုင်",
            phBrand = PhoneBrand.OPPO,
            phModel = "A31",
            case = "မှန်လဲရန်"
        ),

        ServiceData(
            cusName = "တင်ဝင်းစိုး",
            phModel = "Y55",
            phBrand = PhoneBrand.VIVO,
            case = "No Power"
        ),

        ServiceData(
            cusName = "ထက်ထက်ထွန်း",
            phBrand = PhoneBrand.XIAOMI,
            phModel = "Redmi Note 8 Pro",
            case = "Userlock"
        )
    )
}
