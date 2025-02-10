package com.prado.cursocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerpadding ->

                    //Aula 08
                    ShowTextField(innerpadding)

                   // ShowImage(padding)

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
    //Aula 08
    @Composable
    fun ShowTextField(padding: PaddingValues){
        var text by remember { mutableStateOf(value = "") }
        Column(modifier = Modifier
            .padding(padding)
            .fillMaxSize()){
           // TextField(value = text, onValueChange = {text = it})
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(text = "Email")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email
                ),
                shape = RoundedCornerShape(10.dp)
            )
            Text(text = "$text")

        }
        Box(modifier = Modifier.padding(padding).fillMaxSize(), contentAlignment = Alignment.Center){
            // TextField(value = text, onValueChange = {text = it})
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(text = "Email")},
                placeholder = { Text(text = "Email") },
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "") }
            )

        }

    }
    //Aula 07
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
        //Greeting(name = "Alvaro")
       // ShowImage(innerPadding = PaddingValues())
        ShowTextField(padding = PaddingValues())
    }

}

