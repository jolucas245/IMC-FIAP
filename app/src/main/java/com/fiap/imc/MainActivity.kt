package com.fiap.imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.imc.ui.theme.IMCTheme
import com.fiap.imc.utils.InfoText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IMCScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IMCScreen(){

    var weight by rememberSaveable {
        mutableStateOf("")
    }
    var height by rememberSaveable {
        mutableStateOf("")
    }
    var imc by remember {
        mutableStateOf(0.0)
    }
    var imcStatus by remember {
        mutableStateOf(Pair("",0xff4caf50))
    }


    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.vermelho_fiap),
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "Calculadora de IMC",
                        fontFamily = FontFamily.SansSerif,
                    )
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.imc),
                        contentDescription = "Ícone de IMC",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                    )

                }
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .height(IntrinsicSize.Min),
            ) {
                Divider(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 10.dp)
                        .fillMaxHeight()
                        .width(2.dp),
                    color = Color(78, 102, 138, 255),
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 32.dp)
                        .background(Color(239, 238, 255))
                ) {
                    BasicText(
                        text = InfoText.imc,
                        modifier = Modifier.padding(8.dp),
                        style = TextStyle(
                            color = Color(78, 102, 138, 255),
                            textAlign = TextAlign.Justify
                        )
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 32.dp, vertical = 20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp,
                            horizontal = 32.dp
                        )
                    ) {
                        Text(
                            text = "Seus dados",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            color = colorResource(id = R.color.vermelho_fiap)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Seu peso",
                            modifier = Modifier.padding(bottom = 8.dp),
                            color = colorResource(id = R.color.vermelho_fiap)
                        )
                        OutlinedTextField(
                            shape = RoundedCornerShape(16.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(id = R.color.black),
                                focusedBorderColor = colorResource(id = R.color.vermelho_fiap)
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            ),
                            placeholder = {
                                Text(text = "Ex: 59.1")
                            },
                            trailingIcon = {
                                Text("KG")
                            },
                            value = weight,
                            onValueChange = {
                                weight = it
                            }
                        )
                        Text(
                            text = "Sua altura",
                            modifier = Modifier.padding(bottom = 8.dp, top = 20.dp),
                            color = colorResource(id = R.color.vermelho_fiap)
                        )
                        OutlinedTextField(
                            shape = RoundedCornerShape(16.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = colorResource(id = R.color.black),
                                focusedBorderColor = colorResource(id = R.color.vermelho_fiap)
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            ),
                            placeholder = {
                                Text(text = "Ex: 172")
                            },
                            trailingIcon = {
                                Text("cm")
                            },
                            value = height,
                            onValueChange = {
                                height = it
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                imc = calculateIMC(weight.toDouble(), height.toDouble())
                                imcStatus = getStatusIMC(imc)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.vermelho_fiap)
                            )
                        ) {
                            Text(text = "CALCULAR")
                        }
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 32.dp,
                        vertical = 24.dp
                    ),
                colors = CardDefaults.cardColors(containerColor = Color(imcStatus.second)),
                elevation = CardDefaults.elevatedCardElevation(4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .fillMaxSize()
                ) {
                    Column {
                        Text(
                            text = "Resultado",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Box(
                            modifier = Modifier.width(150.dp)
                        ) {
                            Text(
                                text = imcStatus.first,
                                color = Color.White,
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                style = TextStyle(
                                    lineBreak = LineBreak.Simple
                                )
                            )
                        }
                    }
                    Text(
                        text = String.format("%.1f", imc),
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                }
            }
        }
    }
}