package com.example.dotapage.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotapage.R

@Composable
fun RatingBlock(modifier: Modifier = Modifier){
    Text(
        text = stringResource(id = R.string.comments),
        color = Color.White,
        modifier = Modifier.padding(
            start = 24.dp,
            top = 20.dp
        ),
        fontSize = 16.sp
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(start = 24.dp, top = 12.dp)
    ){
        Text(
            text = "4.9",
            color = Color.White,
            fontSize = 48.sp
        )
        Spacer(modifier = modifier.width(17.dp))
        Column {
            RatingBar(modifier,5f)
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.rate_amount) + " reviews",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun RatingBar(modifier:Modifier = Modifier, rating:Float = 4.9f){
    var ratingState by remember{
        mutableFloatStateOf(rating)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        for (i in 1..5){
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                modifier = modifier.size(10.dp),
                tint = if (i <= ratingState) Color.Yellow else Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun RatingBlockPreview(){
    LazyColumn(){
        item{
            RatingBlock()
        }
    }
}

@Preview
@Composable
fun RatingBarPreview(){
    RatingBar()
}
