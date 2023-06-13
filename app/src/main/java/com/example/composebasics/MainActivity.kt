package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
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
    var shouldShowOnboarding by remember { mutableStateOf(true) }

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
@Composable
fun GreetingsComposable(modifier: Modifier = Modifier, names: List<String> = listOf("World", "Compose")){
    Column(
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        for(name in names){
            Greeting(name)
        }
    }
}
@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }

    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(color = MaterialTheme.colors.primary,modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)

                ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
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