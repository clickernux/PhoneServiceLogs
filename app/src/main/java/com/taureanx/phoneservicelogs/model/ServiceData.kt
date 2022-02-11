package com.taureanx.phoneservicelogs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.taureanx.phoneservicelogs.util.PhoneBrand
import java.util.*

@Entity(tableName = "service_data")
data class ServiceData(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    @ColumnInfo(name = "customer_name")
    var cusName: String = "",
    var collectedDate: Date = Date(), // လာအပ်တဲ့နေ့စွဲ

    @ColumnInfo(name = "phone_brand")
    var phBrand: PhoneBrand = PhoneBrand.XIAOMI,

    @ColumnInfo(name = "phone_model")
    var phModel: String = "",
    var case: String = "", //ပြုပြင်ရမည့် အကြာင်းရင်း
    var urgent: Boolean = false, //အရေးကြီး/မကြီး
    var repaired: Boolean = false, //ပြုပြင်ပြီး/မပြီး
    var isTaken: Boolean = false, //ရွေးယူပြီး/မပြီး
    var takenDate: Date? = null, //ရွေးယူခဲ့ရင် ရွေးယူသွားတဲ့နေ့စွဲ
    var contactPhone: String? = null,
    var cost: Long? = null
)

object DummyData{
    val data = listOf(
        ServiceData(
            id = 0,
            cusName = "ထွန်းထွန်းနိုင်",
            phBrand = PhoneBrand.OPPO,
            phModel = "A31",
            case = "မှန်လဲရန်",
            contactPhone = "09256343863"
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
