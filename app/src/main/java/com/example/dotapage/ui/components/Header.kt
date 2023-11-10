package com.example.dotapage.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotapage.R
import com.example.dotapage.ui.theme.AppTheme

@Composable
fun DotaHeader(modifier: Modifier = Modifier){
    Box(modifier = modifier
        .height(369.dp)
        .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(327.dp)
                .fillMaxWidth()
        )
        Box(modifier = Modifier.offset(21.dp, 265.dp)){
            DotaLogo()
        }
        Column(modifier = Modifier
            .offset(124.dp, 300.dp)
            .height(50.dp)){
            Text(
                text = stringResource(id = R.string.game_name),
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = modifier.height(7.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                RatingBar(modifier, 5f)
                Spacer(modifier = modifier.width(10.dp))
                Text(
                    text = stringResource(id = R.string.rate_amount),
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun DotaLogo(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .size(88.dp, 95.dp)
            .clip(RoundedCornerShape(13.dp))
            .background(color = Color.Black)
            .border(
                width = 2.dp,
                color = AppTheme.BgColors.border,
                shape = RoundedCornerShape(13.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(54.dp))
    }
}

@Preview
@Composable
fun DotaHeaderPreview(){
    DotaHeader()
}