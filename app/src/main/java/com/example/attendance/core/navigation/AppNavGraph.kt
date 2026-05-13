package com.example.attendance.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.attendance.feature.attendance.presentation.AttendanceScreen
import com.example.attendance.feature.auth.presentation.LoginScreen
import com.example.attendance.feature.history.presentation.AttendanceHistoryScreen
import com.example.attendance.feature.home.presentation.HomeScreen
import com.example.attendance.feature.mypage.presentation.MyPageScreen

/**
 * 앱의 전체 네비게이션 그래프를 정의하는 Composable 함수
 *
 * @param navController 화면 간 이동을 관리하는 NavHostController
 * @param startDestination 앱 시작 시 표시할 초기 화면 (기본값: 로그인 화면)
 */
@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = ScreenRoute.Login.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // 로그인 화면
        composable(ScreenRoute.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    // 로그인 성공 시 홈 화면으로 이동 / 백스택에서 로그인 화면 제거
                    navController.navigate(ScreenRoute.Home.route) {
                        popUpTo(ScreenRoute.Login.route) { inclusive = true }
                    }
                }
            )
        }

        // 홈 화면
        composable(ScreenRoute.Home.route) {
            HomeScreen(
                navController = navController
            )
        }

        // 출석 체크 화면
        composable(ScreenRoute.Attendance.route) {
            AttendanceScreen(
                navController = navController
            )
        }

        // 출석 내역 화면
        composable(ScreenRoute.History.route) {
            AttendanceHistoryScreen(
                navController = navController
            )
        }

        // 마이페이지
        composable(ScreenRoute.MyPage.route) {
            MyPageScreen(
                navController = navController,
                onLogout = {
                    // 로그아웃 시 로그인 화면으로 이동 / 모든 백스택 제거
                    navController.navigate(ScreenRoute.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}