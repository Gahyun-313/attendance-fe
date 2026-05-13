package com.example.attendance.feature.history.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceHistoryScreen(
    navController: NavHostController,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("출석 내역") }
            )
        },
        // 하단 네비게이션 바
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "출석 내역 화면",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(
    name = "Attendance History Screen Preview",
    showBackground = true
)
@Composable
fun AttendanceHistoryScreenPreview() {
    MaterialTheme {
        AttendanceHistoryScreen(
            navController = rememberNavController()
        )
    }
}