package com.prado.cursocompose

import android.nfc.Tag
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import java.util.logging.Logger

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerpadding ->

                    //Aula 13
                    FormularioCadastro(innerpadding)
                    //Aula 12
                   // ContainersExemple2(innerpadding)
                    //Aula 11
                    //ContainersExemple(innerpadding)
                    //Aula 10
                   // ModifierPropeties(innerpadding)
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
    //Aula 13
    @Composable
    fun FormularioCadastro(paddingValues: PaddingValues){
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.login_avatar),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier
                    .size(100.dp)
                    .border(color = Color.Gray,
                        width = 1.dp,
                        shape = CircleShape)
                    .padding(10.dp)
            )
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = { Text(text = "Nome")},
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.width(5.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email")},
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(10.dp))
              OutlinedButton(
                onClick = {
                    Log.i("Form", "FormularioCadastro: Nome: ${name}, E-mail: ${email}")
                }
            ) {
                Text(text = "Cadastrar")
            }
        }
    }

    //Aula 12
    @Composable
    fun ContainersExemple2(padding: PaddingValues){
        val users = listOf(
            "Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Elijah", "Sophia", "William", "Isabella",
            "James", "Mia", "Benjamin", "Evelyn", "Lucas", "Harper", "Henry", "Camila", "Alexander", "Gianna",
            "Michael", "Abigail", "Ethan", "Luna", "Daniel", "Ella", "Jacob", "Elizabeth", "Logan", "Sofia",
            "Jackson", "Avery", "Levi", "Scarlett", "Sebastian", "Emily", "Mateo", "Aria", "Jack", "Penelope",
            "Owen", "Chloe", "Theodore", "Layla", "Aiden", "Mila", "Samuel", "Nora", "Joseph", "Hazel",
            "John", "Madison", "David", "Ellie", "Wyatt", "Lily", "Matthew", "Nova", "Luke", "Isla",
            "Asher", "Grace", "Carter", "Violet", "Julian", "Aurora", "Grayson", "Riley", "Leo", "Zoey",
            "Jayden", "Willow", "Gabriel", "Emilia", "Isaac", "Stella", "Lincoln", "Zoe", "Anthony", "Victoria",
            "Hudson", "Hannah", "Dylan", "Addison", "Ezra", "Lucy", "Thomas", "Paisley", "Charles", "Savannah",
            "Christopher", "Serenity", "Jaxon", "Skylar", "Maverick", "Leah", "Josiah", "Lillian", "Isaiah", "Claire"
        )
        val users2 = mapOf(
            1 to "Liam", 2 to "Olivia", 3 to "Noah", 4 to "Emma", 5 to "Oliver", 6 to "Ava",
            7 to "Elijah", 8 to "Sophia", 9 to "William", 10 to "Isabella",
            11 to "James", 12 to "Mia", 13 to "Benjamin", 14 to "Evelyn", 15 to "Lucas", 16 to "Harper",
            17 to "Henry", 18 to "Camila", 19 to "Alexander", 20 to "Gianna",
            21 to "Michael", 22 to "Abigail", 23 to "Ethan", 24 to "Luna", 25 to "Daniel", 26 to "Ella",
            27 to "Jacob", 28 to "Elizabeth", 29 to "Logan", 30 to "Sofia",
            31 to "Jackson", 32 to "Avery", 33 to "Levi", 34 to "Scarlett", 35 to "Sebastian", 36 to "Emily",
            37 to "Mateo", 38 to "Aria", 39 to "Jack", 40 to "Penelope",
            41 to "Owen", 42 to "Chloe", 43 to "Theodore", 44 to "Layla", 45 to "Aiden", 46 to "Mila",
            47 to "Samuel", 48 to "Nora", 49 to "Joseph", 50 to "Hazel",
            51 to "John", 52 to "Madison", 53 to "David", 54 to "Ellie", 55 to "Wyatt", 56 to "Lily",
            57 to "Matthew", 58 to "Nova", 59 to "Luke", 60 to "Isla",
            61 to "Asher", 62 to "Grace", 63 to "Carter", 64 to "Violet", 65 to "Julian", 66 to "Aurora",
            67 to "Grayson", 68 to "Riley", 69 to "Leo", 70 to "Zoey",
            71 to "Jayden", 72 to "Willow", 73 to "Gabriel", 74 to "Emilia", 75 to "Isaac", 76 to "Stella",
            77 to "Lincoln", 78 to "Zoe", 79 to "Anthony", 80 to "Victoria",
            81 to "Hudson", 82 to "Hannah", 83 to "Dylan", 84 to "Addison", 85 to "Ezra", 86 to "Lucy",
            87 to "Thomas", 88 to "Paisley", 89 to "Charles", 90 to "Savannah",
            91 to "Christopher", 92 to "Serenity", 93 to "Jaxon", 94 to "Skylar", 95 to "Maverick", 96 to "Leah",
            97 to "Josiah", 98 to "Lillian", 99 to "Isaiah", 100 to "Claire"
        )
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize()){
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                users2.forEach{key, value ->
                    item{
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Absolute.SpaceAround,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Chave $key")
                            Text(text = "Valor $value",
                                modifier = Modifier
                                    .padding(10.dp),
                                color = Color.Blue,
                                fontSize = 17.sp
                            )
                        }

                    }
                }
            }
           /* LazyHorizontalGrid(
                rows = GridCells.Fixed(3),
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ) { items(999) {i ->
                Text(text = "Teste $i",
                    modifier = Modifier
                        .padding(10.dp),
                    color = Color.Blue,
                    fontSize = 17.sp
                )}
            }*/
          /*  LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                items(999) {i ->
                    Text(text = "Teste $i",
                        modifier = Modifier
                            .padding(10.dp),
                        color = Color.Blue,
                        fontSize = 17.sp
                    )
                }
            }*/
           /* LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                users.forEach{user ->
                    item{
                        Text(text = user,
                            modifier = Modifier
                                .padding(10.dp),
                            color = Color.Blue,
                            fontSize = 17.sp
                        )
                    }

            }*/
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
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(cornerSize)
                    )
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
            OutlinedButton(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
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
      //  ContainersExemple(padding = PaddingValues())
       // ContainersExemple2(padding = PaddingValues())
        FormularioCadastro(paddingValues = PaddingValues())
    }

}

