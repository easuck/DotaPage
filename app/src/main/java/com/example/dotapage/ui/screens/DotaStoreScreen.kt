package com.example.dotapage.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotapage.R
import com.example.dotapage.ui.components.Comments
import com.example.dotapage.ui.components.CustomButton
import com.example.dotapage.ui.components.DotaHeader
import com.example.dotapage.ui.components.RatingBlock
import com.example.dotapage.ui.components.ScrollableChipsRow
import com.example.dotapage.ui.components.VideoPreviewRow
import com.example.dotapage.ui.theme.AppTheme

@Composable
fun DotaScreen(){
    val lazyListState = rememberLazyListState()
    val chips = listOf("MOBA", "MULTIPLAYER", "STRATEGY")

    LazyColumn(state = lazyListState,
        modifier = Modifier.fillMaxSize()
    ){
        item {
            DotaHeader()
        }
        item{
            ScrollableChipsRow(chips)
        }
        item {
            Text(
                text = stringResource(id = R.string.dota_description),
                color = AppTheme.TextColors.description,
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 43.dp
                ),
                fontSize = 12.sp
            )
        }
        item{
            VideoPreviewRow(
                images = listOf(
                    R.drawable.video_preview1,
                    R.drawable.video_preview2
                )
            )
        }
        item{
            RatingBlock()
        }
        item{
            Comments()
        }
        item {
            CustomButton()
        }
    }
}

@Preview
@Composable
fun DotaScreenPreview(){
    DotaScreen()
}