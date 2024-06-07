package com.shu.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shu.drawables.R

@Composable
fun AuthScreenLogin(
) {

    Column(
        modifier = Modifier.padding(bottom = 120.dp),
    ) {
        Image(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_frog),
            contentDescription = "icon for navigation item"
        )
        Image(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.humblr),
            contentDescription = "icon for navigation item"
        )

        Text(
            text = stringResource(id = com.shu.strings.R.string.auth_under_logo),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = com.shu.strings.R.string.successful_authorization),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

    }

}