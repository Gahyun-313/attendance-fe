package com.example.attendance.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
) {
    // 현재 라우트 자동 감지
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        // 홈 메뉴
        NavigationBarItem(
            selected = currentRoute == ScreenRoute.Home.route,
            onClick = {
                if (currentRoute != ScreenRoute.Home.route) {
                    navController.navigate(ScreenRoute.Home.route) {
                        popUpTo(ScreenRoute.Home.route) { inclusive = true }
                    }
                }
            },
            icon = { Icon(Icons.Default.Home, "홈") },
            label = { Text("홈") }
        )

        // 출석 메뉴
        NavigationBarItem(
            selected = currentRoute == ScreenRoute.Attendance.route,
            onClick = {
                if (currentRoute != ScreenRoute.Attendance.route) {
                    navController.navigate(ScreenRoute.Attendance.route)
                }
            },
            icon = { Icon(Icons.Default.CheckCircle, "출석") },
            label = { Text("출석") }
        )

        // 내역 메뉴
        NavigationBarItem(
            selected = currentRoute == ScreenRoute.History.route,
            onClick = {
                if (currentRoute != ScreenRoute.History.route) {
                    navController.navigate(ScreenRoute.History.route)
                }
            },
            icon = { Icon(Icons.AutoMirrored.Filled.List, "내역") },
            label = { Text("내역") }
        )

        // 마이 페이지 메뉴
        NavigationBarItem(
            selected = currentRoute == ScreenRoute.MyPage.route,
            onClick = {
                if (currentRoute != ScreenRoute.MyPage.route) {
                    navController.navigate(ScreenRoute.MyPage.route)
                }
            },
            icon = { Icon(Icons.Default.Person, "마이") },
            label = { Text("마이") }
        )
    }
}

/**
 * 미리보기
 */
@Preview(
    name = "BottomNavigationBar Screen Preview",
    showBackground = true
)
@Composable
fun BottomNavigationBarPreview() {
    MaterialTheme {
        BottomNavigationBar(
            navController = rememberNavController(),
        )
    }
}