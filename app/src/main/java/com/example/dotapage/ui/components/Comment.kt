package com.example.dotapage.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Preview
@Composable
fun Comments(){
    Column(modifier = Modifier.padding(top = 30.dp)) {
        CommentBlock(R.drawable.user_1, R.string.username_1, R.string.date_1, R.string.comment_1)
        Divider(
            color = AppTheme.BgColors.divider,
            thickness = 1.dp,
            modifier = Modifier.padding(
                start = 37.dp,
                end = 37.dp,
                top = 24.dp,
                bottom = 24.dp
            )
        )
        CommentBlock(R.drawable.user_2, R.string.username_2, R.string.date_2, R.string.comment_2)
    }
}


@Composable
fun CommentBlock(userImage:Int, username: Int, date: Int, comment: Int){
    Column(modifier = Modifier.padding(
        start = 24.dp,
        end = 24.dp
    )) {
        Row(){
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(36.dp)
            ){
                Image(
                    painter = painterResource(id = userImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = stringResource(id = username),
                    color = Color.White,
                    fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = stringResource(id = date),
                    color = AppTheme.TextColors.date,
                    fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(17.dp))
        Text(text = stringResource(id = comment),
            color = AppTheme.TextColors.comment,
            fontSize = 12.sp)
    }
}