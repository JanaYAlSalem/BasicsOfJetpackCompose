package com.janayalsalem.basicsofjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.janayalsalem.basicsofjetpackcompose.ui.theme.BasicsOfJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsOfJetpackComposeTheme {
//                MyApp(listOf("Jana AlSalem"))
                RadioButtonLanguagesColumn()
//                RadioButtonLanguagesRow()

            }
        }
    }
}


@Composable
fun MyApp(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {

    val expanded = remember { mutableStateOf(false) }

    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
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

@Composable
private fun RadioButtonLanguagesColumn() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val selectedLanguages = remember { mutableStateOf("") }
        Text("Select Languages")
        Spacer(modifier = Modifier.size(16.dp))
        Row {
            RadioButton(selected = selectedLanguages.value == languages.ar, onClick = {
                selectedLanguages.value = languages.ar
            })
            Spacer(modifier = Modifier.size(16.dp))
            Text(languages.ar)
            Spacer(modifier = Modifier.size(16.dp))
//            RadioButton(selected = selectedLanguages.value == languages.en, onClick = {
//                selectedLanguages.value = languages.en
//            })
//            Spacer(modifier = Modifier.size(16.dp))
//            Text(languages.en)

        }
        Row{
            RadioButton(selected = selectedLanguages.value == languages.en, onClick = {
                selectedLanguages.value = languages.en
            })
            Spacer(modifier = Modifier.size(16.dp))
            Text(languages.en)

        }
        OutlinedButton(
            onClick = { }
        ) {
            Text("OK")
        }
    }

}

@Composable
private fun RadioButtonLanguagesRow() {
    Row(modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val selectedLanguages = remember { mutableStateOf("") }
        Text("Select Languages")
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            RadioButton(selected = selectedLanguages.value == languages.ar, onClick = {
                selectedLanguages.value = languages.ar
            })
            Spacer(modifier = Modifier.size(16.dp))
            Text(languages.ar)
            Spacer(modifier = Modifier.size(16.dp))
            RadioButton(selected = selectedLanguages.value == languages.en, onClick = {
                selectedLanguages.value = languages.en
            })
            Spacer(modifier = Modifier.size(16.dp))
            Text(languages.en)

        }
        OutlinedButton(
            onClick = { }
        ) {
            Text("OK")
        }
    }

}

object languages {
    const val ar = "Arabic"
    const val en = "English"
}

@Composable
@Preview
private fun Show () {
//    RadioButtonLanguagesRow()
    RadioButtonLanguagesColumn()

}
