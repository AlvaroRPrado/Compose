package com.prado.cursocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prado.cursocompose.ui.theme.BlueText
import com.prado.cursocompose.ui.theme.CursoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->

                    ShowImage(padding)
                    
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
                   /* Greeting(
                        name = "Alvaro",
                        modifier = Modifier.padding(padding)
                    )*/


                }
            }
        }
    }

    @Composable
    private fun ShowImage(innerPadding: PaddingValues) {
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            /*Image(
                painter = painterResource(id = R.drawable.jetpack_compose_image),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )*/
            Icon(
                painter = painterResource(R.drawable.login_avatar), contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier.size(100.dp)
                )
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
    @Preview(showBackground = true)
    fun GreetingPreview(){
        Greeting(name = "Alvaro")
        ShowImage(innerPadding = PaddingValues())
    }

}

