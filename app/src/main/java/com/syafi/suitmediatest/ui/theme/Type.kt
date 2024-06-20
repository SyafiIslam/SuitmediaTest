package com.syafi.suitmediatest.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.syafi.suitmediatest.R

object Type {

    fun textsmRegular() = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontSize = 14.sp,
        lineHeight = 20.sp
    )

    fun textsmBold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontSize = 14.sp,
        lineHeight = 20.sp
    )

    fun textlgSemiBold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
        fontSize = 18.sp,
        lineHeight = 28.sp
    )

    fun textxlBold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontSize = 20.sp,
        lineHeight = 30.sp
    )

    fun displayxsBold() = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontSize = 24.sp,
        lineHeight = 32.sp
    )
}