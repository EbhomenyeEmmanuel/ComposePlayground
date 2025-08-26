package com.emma.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.emma.composeplayground.ui.pager.OfficialHorizontalPagerSample
import com.emma.composeplayground.ui.theme.ComposePlaygroundTheme
import com.emma.composeplayground.ui.theme.Purple40

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlaygroundTheme {
                AppContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val titles = listOf("Pager", "Gradients")
    val pagerState: PagerState = rememberPagerState { titles.size }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(titles[pagerState.currentPage]) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        OfficialHorizontalPagerSample(
            Modifier.padding(innerPadding),
            pageCount = titles.size,
            pagerState = pagerState
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePlaygroundTheme {
        AppContent()
    }
}