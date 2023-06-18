import android.content.res.Configuration
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

@Composable
fun GreetingsComposable(modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }
){
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}


@Composable
fun Greeting(name: String,modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(if (expanded.value) 48.dp else 0.dp

        , animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    );

    Surface(color = MaterialTheme.colors.primary,modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))

            ) {
                Text(text = "Hello", style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold))
                Text(text = name, style = MaterialTheme.typography.subtitle1.copy(fontSize = 16.sp, fontWeight = FontWeight.SemiBold))
            }
            IconButton(

                onClick =  { expanded.value = !expanded.value }
            ) {
                Icon((if(expanded.value) Icons.Filled.Menu else Icons.Filled.ExitToApp),contentDescription = "")
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun TilePreviewLight(){
    ComposeBasicsTheme() {
        Greeting(name = "Dude")
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TilePreviewDark(){
    ComposeBasicsTheme() {
        Greeting(name = "Dude")
    }
}