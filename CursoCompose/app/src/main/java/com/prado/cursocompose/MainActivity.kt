package com.prado.cursocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prado.cursocompose.ui.theme.BlueText
import com.prado.cursocompose.ui.theme.CursoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerpadding ->

                    //Aula 11
                    ContainersExemple(innerpadding)
                    //Aula 10
                    ModifierPropeties(innerpadding)
                    //Aula 09
                    //ShowButton(innerpadding)

                    //Aula 08
                  //  ShowTextField(innerpadding)

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
    //Aula 11
    @Composable
    fun ContainersExemple(padding: PaddingValues){
        Box(modifier = Modifier
                .padding(padding)
                .fillMaxSize()){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                for (i in 0..10){
                    Text(text = "Teste $i",
                        modifier = Modifier
                            .padding(10.dp),
                        color = Color.Blue,
                        fontSize = 17.sp
                    )
                }



               /* Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceAround) {
                    Text(text = "Teste 1")
                    Text(text = "Teste 2")
                }*/
            }

        }
    }
    //Aula 10
    @Composable
    fun ModifierPropeties(padding: PaddingValues){
        val cornerSize  = 8.dp
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = "Cadastrar",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable {
                        Log.i("BotaoFeke", "ModifierPropeties: O nosso botao fake foi clicado!!")
                    }
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(cornerSize))
                    .clip(RoundedCornerShape(cornerSize))
                    .width(200.dp)
                    .padding(20.dp)
            )

        }
    }
    //Aula 09
    @Composable
    fun ShowButton(padding: PaddingValues){
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center){
           /* Button(onClick = {}) {
                Text(text = "Cadastrar")
                Icon(Icons.Default.Done, contentDescription = "")
            }*/
            OutlinedButton(modifier = Modifier.padding(8.dp).fillMaxWidth(),
                onClick = {Log.i("botao", "ShowButton: O botao foi clicado!!!")},
                border = BorderStroke(2.dp, Color.Red),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green),
                shape = CircleShape,
            ) {
                Text(text = "Cadastrar")
                Icon(Icons.Default.Done, contentDescription = "")
            }

           /* IconButton(
                onClick = {}
            ) {
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "")
            }*/
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
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize(), contentAlignment = Alignment.Center){
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
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
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
       // ShowTextField(padding = PaddingValues())
       // ShowButton(padding = PaddingValues())
       // ModifierPropeties(padding = PaddingValues())
        ContainersExemple(padding = PaddingValues())
    }

}

