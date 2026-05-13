package com.example.attendance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.attendance.core.navigation.AppNavGraph
import com.example.attendance.ui.theme.AttendanceTheme

/**
 * 앱의 메인 액티비티
 * Hilt를 사용한 의존성 주입을 위해 @AndroidEntryPoint 어노테이션 적용
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 상태바, 네비게이션바 영역까지 레이아웃 확대
        enableEdgeToEdge()

        setContent {
            // 앱 테마 적용
            AttendanceTheme {
                // 전체 화면 채우는 Surface 컴포넌트
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // NavController 생성 및 네비게이션 그래프 설정
                    val navController = rememberNavController()
                    AppNavGraph(navController = navController)
                }
            }
        }
    }
}