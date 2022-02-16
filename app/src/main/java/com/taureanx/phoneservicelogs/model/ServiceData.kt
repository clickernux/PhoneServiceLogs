package com.taureanx.phoneservicelogs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "service_data")
data class ServiceData(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    @ColumnInfo(name = "customer_name")
    var cusName: String = "",
    var collectedDate: Date = Date(), // လာအပ်တဲ့နေ့စွဲ

    @ColumnInfo(name = "phone_brand")
    var phBrand: String = "",

    @ColumnInfo(name = "phone_model")
    var phModel: String = "",

    @ColumnInfo(name = "repair_case")
    var repair_case: String = "", //ပြုပြင်ရမည့် အကြာင်းရင်း
    var urgent: Boolean = false, //အရေးကြီး/မကြီး
    var repaired: Boolean = false, //ပြုပြင်ပြီး/မပြီး
    var isTaken: Boolean = false, //ရွေးယူပြီး/မပြီး
    var takenDate: Date? = null, //ရွေးယူခဲ့ရင် ရွေးယူသွားတဲ့နေ့စွဲ
    var contactPhone: String? = null,
    var cost: String = "",
    var note: String = ""
)
