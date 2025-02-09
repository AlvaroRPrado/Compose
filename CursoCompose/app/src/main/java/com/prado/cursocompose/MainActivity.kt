package com.prado.cursocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.prado.cursocompose.ui.theme.BlueText
import com.prado.cursocompose.ui.theme.CursoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                   /* Box(
                        modifier = Modifier.padding(padding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                         Text(
                            text = "Hello World",
                            color = Color.Red,
                            fontSize = 34.sp,
                            fontWeight = FontWeight.Bold,
                        )

                    }*/
                    Greeting(
                        name = "Alvaro",
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier){
        Text(text = "Hello $name",
            modifier = modifier,
            color = BlueText
        )
    }

    @Composable
    @Preview
    fun GreetingPreview(){
        Greeting(name = "Alvaro")
    }

}

