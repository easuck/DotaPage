package com.example.dotapage.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dotapage.R

@Composable
fun VideoPreview(imageId : Int){
    Image(painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier.size(240.dp, 135.dp))
}

@Composable
fun VideoPreviewWithButton(imageId:Int = R.drawable.video_preview1){
    Box(
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(240.dp, 135.dp))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp)
                .background(Color(0x3DFFFFFF)),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.play_button),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun VideoPreviewRow(images: List<Int>){
    LazyRow(
        contentPadding = PaddingValues(start = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.height(135.dp)
    ){
        itemsIndexed(images){ index, image ->
            if (index == 0){
                VideoPreviewWithButton(imageId = image)
            }
            else{
                VideoPreview(imageId = image)
            }
        }
    }
}

@Preview
@Composable
fun VideoPreviewPreview(){
    val images:List<Int> = listOf(R.drawable.video_preview1, R.drawable.video_preview2)
    VideoPreviewRow(images)
}