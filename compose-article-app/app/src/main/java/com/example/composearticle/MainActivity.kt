package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleLayout(
                        titleMessage = stringResource(R.string.title_messeage),
                        firstParagraphMessage = stringResource(R.string.first_paragraph),
                        lastParagraphMessage = stringResource(R.string.last_paragraph),
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticleLayout(
    titleMessage: String,
    firstParagraphMessage: String,
    lastParagraphMessage: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        BackgroundImage()
        TitleText(titleMessage)
        FirstParagraph(firstParagraphMessage)
        LastParagraph(lastParagraphMessage)
    }
}

@Composable
fun BackgroundImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = "compose background image",
    )
}

@Composable
fun TitleText(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun FirstParagraph(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    )
}

@Composable
fun LastParagraph(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeArticleLayout(
            titleMessage = stringResource(R.string.title_messeage),
            firstParagraphMessage = stringResource(R.string.first_paragraph),
            lastParagraphMessage = stringResource(R.string.last_paragraph),
        )
    }
}