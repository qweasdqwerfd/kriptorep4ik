package com.example.kriptorep4ik.parse_data

class ParserModel(
    val letterCode: String,
    val change: String,
    val percentageChange: String,
    val currency: String,
    val rate: String,
    val unit: String,
    val date: String
) {
    override fun toString(): String {
        return "AdditionChangesModel(letterCode='$letterCode', change='$change', percentageChange='$percentageChange', " +
                "currency = '$currency', rate = '$rate', unit = '$unit', date = '$date')"
    }
}