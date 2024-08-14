package com.example.birthdayapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdayapplication.ui.theme.BirthdayApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            BirthdayApplicationTheme {
                Myapp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Myapp(modifier: Modifier = Modifier) {
    Surface(modifier = modifier) {
        GreetingImage(message = stringResource(R.string.happy_birthday_text), from = stringResource(R.string.from_text))
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 96.sp,
            textAlign = TextAlign.Center,
            modifier = modifier,
        )
        Text(
            text = from,
            fontSize = 20.sp,
            lineHeight = 26.sp,
            modifier = modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message,
            from,
            modifier = modifier
                .padding(8.dp)
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Birthday Card Preview"
)
@Composable
fun BirthdayCardPreview() {
    BirthdayApplicationTheme {
        Myapp(modifier = Modifier.fillMaxSize())
    }
}