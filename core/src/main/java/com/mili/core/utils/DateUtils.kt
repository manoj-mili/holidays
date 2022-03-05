package com.mili.core.utils

import java.text.SimpleDateFormat
import java.util.*


const val GENERIC_DATE_FORMAT = "yyyy-MM-dd"
const val DISPLAY_DATE_FORMAT = "E, dd MMM yyyy"

enum class DayOfTheWeek {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
}

val longWeekends = setOf(DayOfTheWeek.Friday.name, DayOfTheWeek.Monday.name)

fun getDayFromDate(date: String): String {
    val formattedDate = SimpleDateFormat(GENERIC_DATE_FORMAT, Locale.getDefault()).parse(date)
    return formattedDate?.getDayOfWeek() ?: ""
}


fun getFormattedDate(date: String, format: String = DISPLAY_DATE_FORMAT): String {
    val parsedDate = SimpleDateFormat(GENERIC_DATE_FORMAT, Locale.getDefault()).parse(date)
    val formatter = SimpleDateFormat(format)
    return formatter.format(parsedDate)
}

fun Date.getDayOfWeek(): String {
    val c = Calendar.getInstance().apply { time = this@getDayOfWeek }
    return when (c.get(Calendar.DAY_OF_WEEK)) {
        Calendar.SUNDAY -> {
            DayOfTheWeek.Sunday.name
        }
        Calendar.MONDAY -> {
            DayOfTheWeek.Monday.name
        }
        Calendar.TUESDAY -> {
            DayOfTheWeek.Tuesday.name
        }
        Calendar.WEDNESDAY -> {
            DayOfTheWeek.Wednesday.name
        }
        Calendar.THURSDAY -> {
            DayOfTheWeek.Thursday.name
        }
        Calendar.FRIDAY -> {
            DayOfTheWeek.Friday.name
        }
        Calendar.SATURDAY -> {
            DayOfTheWeek.Saturday.name
        }
        else -> {
            ""
        }
    }

}

fun isNationalHoliday(types: String): Boolean {
    return types.split(",").contains("National holiday")
}

fun isLongWeekend(dayOfWeek: String): Boolean = (longWeekends.contains(dayOfWeek))