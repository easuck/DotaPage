package com.example.dotapage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.dotapage.ui.theme.AppTheme
import com.example.dotapage.ui.theme.DotaPageTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            DotaPageTheme {
                MainScreen()
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MainScreen() {
    DotaPageTheme {
        ApplySystemBarColors()
        // A surface container using the 'background' color from the theme
        Surface(
            color = AppTheme.BgColors.primary,
            modifier = Modifier.fillMaxSize(),
        ) {
            DotaScreen()
        }
    }
}

@Composable
fun DotaScreen(){
    val context = LocalContext.current
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

@Preview
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
fun RatingBlockPreview(){
    LazyColumn(){
        item{
            RatingBlock()
        }
    }
}
@Composable
fun RatingBlock(modifier:Modifier = Modifier){
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

@Preview
@Composable
fun CustomButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(AppTheme.ButtonColors.primary),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = stringResource(id = R.string.installation_button),
            color = Color.Black,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            letterSpacing = 0.6.sp
        )
    }
}

@Composable
fun VideoPreview(imageId : Int){
    Image(painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier.size(240.dp, 135.dp))
}

@Preview
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
                .background(Color.Gray),
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


@Composable
private fun ApplySystemBarColors() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(color = Color.Transparent)
        systemUiController.setNavigationBarColor(color = Color.Transparent)
    }
}

@Preview
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