package com.taureanx.phoneservicelogs.database

import androidx.room.TypeConverter
import com.taureanx.phoneservicelogs.util.PhoneBrand
import java.util.*

class DataTypeConverter {

    @TypeConverter
    fun fromDate(date: Date?): Long?{
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date?{
        return millisSinceEpoch?.let {
            Date(it)
        }
    }

    @TypeConverter
    fun fromBrand(brand: PhoneBrand): String{
        return brand.toString()
    }

    @TypeConverter
    fun toBrand(brand: String): PhoneBrand{
        return PhoneBrand.valueOf(brand)
    }
}