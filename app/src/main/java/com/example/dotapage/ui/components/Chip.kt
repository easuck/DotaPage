package com.example.dotapage.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotapage.ui.theme.AppTheme

@Composable
fun ScrollableChipsRow(chips:List<String>){
    LazyRow(
        modifier = Modifier.padding(
            start = 24.dp,
            top = 20.dp,
            bottom = 30.dp
        )
    ){
        items(chips) {
                item -> ChipContent(item)
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun ChipContent(text:String = "MOBA"){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(AppTheme.BgColors.chip)
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = 5.dp,
                bottom = 5.dp
            )
    ){
        Text(
            text = text,
            color = AppTheme.TextColors.chip,
            fontSize = 10.sp
        )
    }
}

@Preview
@Composable
fun ChipsRowPreview(){
    val chips:List<String> = listOf("MOBA", "MULTIPLAYER", "STRATEGY")
    ScrollableChipsRow(chips)
}