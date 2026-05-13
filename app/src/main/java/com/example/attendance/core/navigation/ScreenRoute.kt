package com.example.attendance.core.navigation

sealed class ScreenRoute(val route: String) {
    data object Login : ScreenRoute("login")
    data object Attendance : ScreenRoute("attendance")
    data object Home : ScreenRoute("home")
    data object History : ScreenRoute("history")
    data object MyPage : ScreenRoute("mypage")
}