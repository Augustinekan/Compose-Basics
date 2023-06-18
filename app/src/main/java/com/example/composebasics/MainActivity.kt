package com.example.composebasics

import Greeting
import GreetingsComposable
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme() {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview
@Composable
fun MyAppPreview() {
    ComposeBasicsTheme {
        MyApp(Modifier.fillMaxSize())
    }
}
@Composable
private fun MyApp(modifier: Modifier = Modifier){
    var shouldShowOnboarding by rememberSaveable{ mutableStateOf(true) }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background
    ) {
        if (shouldShowOnboarding) {
            OnBoardingScreen(onContinueClicked = {shouldShowOnboarding = false})
        } else {
            GreetingsComposable()
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeBasicsTheme {
        MyApp()
    }
}



@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier,
                     onContinueClicked: () -> Unit,
                     ) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview() {
    ComposeBasicsTheme {
        OnBoardingScreen(onContinueClicked = {})
    }
}

