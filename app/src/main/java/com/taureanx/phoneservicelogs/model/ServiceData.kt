package com.taureanx.phoneservicelogs.model

import com.taureanx.phoneservicelogs.util.PhoneBrand
import java.util.*

data class ServiceData(
    val id: Long,
    var cusName: String = "",
    var bigShopName: String = "",
    var collectedDate: Date = Date(), // လာအပ်တဲ့နေ့စွဲ
    var phBrand: PhoneBrand,
    var phModel: String = "",
    var case: String = "", //ပြုပြင်ရမည့် အကြာင်းရင်း
    var urgent: Boolean = false, //အရေးကြီး/မကြီး
    var repaired: Boolean = false, //ပြုပြင်ပြီး/မပြီး
    var isTaken: Boolean = false, //ရွေးယူပြီး/မပြီး
    var takenDate: Date? = null //ရွေးယူခဲ့ရင် ရွေးယူသွားတဲ့နေ့စွဲ
)

object DummyData{
    val data = listOf(
        ServiceData(
            id = 0,
            cusName = "ထွန်းထွန်းနိုင်",
            phBrand = PhoneBrand.OPPO,
            phModel = "A31",
            case = "မှန်လဲရန်"
        ),

        ServiceData(
            id = 1,
            cusName = "တင်ဝင်းစိုး",
            phModel = "Y55",
            phBrand = PhoneBrand.VIVO,
            case = "No Power"
        ),

        ServiceData(
            id = 2,
            cusName = "ထက်ထက်ထွန်း",
            phBrand = PhoneBrand.XIAOMI,
            phModel = "Redmi Note 8 Pro",
            case = "Userlock"
        )
    )
}
