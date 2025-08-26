package com.emma.composeplayground.ui.pager

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emma.composeplayground.common.ui.components.PagerDotsIndicator

@Composable
fun OfficialHorizontalPagerSample(modifier: Modifier) {
    val pageCount = 5
    val pagerState: PagerState = rememberPagerState { pageCount }

    OfficialHorizontalPagerSample(modifier, pageCount, pagerState)
}

@Composable
fun OfficialHorizontalPagerSample(
    modifier: Modifier,
    pageCount: Int,
    pagerState: PagerState
) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            // Each page's content
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Page #$page")
            }
        }

        // Simple dot indicator (you can animate it if you want)
        PagerDotsIndicator(
            totalDots = pageCount,
            selectedIndex = pagerState.currentPage,
            modifier = Modifier
                .padding(12.dp),
        )
    }
}
