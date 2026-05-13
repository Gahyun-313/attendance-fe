package com.example.attendance.feature.home.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.attendance.core.navigation.BottomNavigationBar
import com.example.attendance.core.navigation.ScreenRoute

/**
 * 홈 화면
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold(
        // 상단 앱바
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("HOME") },
                actions = {
                }
            )
        },
        // 하단 네비게이션 바
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { paddingValues ->
        // 메인 컨텐츠 영역
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Scaffold 패딩 적용
                .padding(24.dp), // 추가 여백
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text(
                    text = "홈",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

/**
 * AttendanceScreen 미리보기
 */
@Preview(
    name = "Attendance Screen Preview",
    showBackground = true
)
@Composable
fun AttendanceScreenPreview() {
    MaterialTheme {
        HomeScreen(
            navController = rememberNavController()
        )
    }
}