package com.example.dotapage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.WindowCompat
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
            color = Color.Black,
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

    LazyColumn(state = lazyListState,
        modifier = Modifier.fillMaxSize()
    ){
        item {
            DotaHeader()
        }
        item {
            Text(
                text = stringResource(id = R.string.dota_description),
                color = Color.White,
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 69.dp,
                    bottom = 43.dp
                )
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
        item {
            CustomButton()
        }
    }
}

@Preview
@Composable
fun CustomButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(Color.Yellow)
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

@Composable
fun VideoPreviewRow(images: List<Int>){
    LazyRow(
        contentPadding = PaddingValues(start = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.height(135.dp)
    ){
        items(images){
            image -> VideoPreview(imageId = image)
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
                color = Color(0xFF1F2430),
                shape = RoundedCornerShape(13.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(54.dp))
    }
}