package com.example.dotapage.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dotapage.R
import com.example.dotapage.ui.theme.AppTheme

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

@Preview
@Composable
fun CustomButtonPreview(){
    CustomButton()
}