package com.chelios.jetpackcomposebasics

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chelios.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(text = "Hello")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Luka")
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)) {
                    ImageCard(
                        painter = painterResource(id = R.drawable.lotr),
                        contentDescription = "Lord of the Rings",
                        title = "Lord of the Rings")
                }
                Spacer(modifier = Modifier.height(8.dp))

                /** States **/
                Column(
                    modifier = Modifier.height(100.dp)
                ) {
                    val color = remember {
                        mutableStateOf(Color.Yellow)
                    }
                    ColorBox(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        color.value = it
                    }
                    Box(
                        modifier = Modifier
                            .background(color.value)
                            .weight(1f)
                            .fillMaxSize()
                    ) {

                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                /** TextFields, Buttons, Showing Snackbars **/
                val scaffoldState = rememberScaffoldState()
                var textFieldState by remember {
                    mutableStateOf("")
                }
                val scope = rememberCoroutineScope()
                Scaffold(
                    modifier = Modifier.height(100.dp).fillMaxWidth(),
                    scaffoldState = scaffoldState
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 30.dp)
                    ) {
                        TextField(
                            value = textFieldState,
                            label = {
                                Text(text = "Enter your name:")
                            },
                            onValueChange = {
                                textFieldState = it
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                            }
                        }) {
                            Text(text = "Please greet me")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                val scrollState = rememberScrollState() //for normal Column to be scrollable
                LazyColumn(
//                    modifier = Modifier.verticalScroll(scrollState)
                ) {
//                    items(100) {
//                        Text(
//                            text = "Item $it",
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 4.dp),
//                            textAlign = TextAlign.Center
//                        )
//                    }
                    itemsIndexed(
                        listOf("item1", "item2", "item3", "item4", "item5","item6", "item7", "item8", "item9", "item10")
                    ) { index, item ->
                        Text(
                            text = item,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                ))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}

/** States **/
@SuppressLint("UnrememberedMutableState")
@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {

    
    Box(
        modifier = modifier
            .background(Color.Red)
            .clickable {
                updateColor(
                    Color(
                        red = Random.nextFloat(),
                        green = Random.nextFloat(),
                        blue = Random.nextFloat(),
                        alpha = 1f
                    )
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Change color below")
    }
}

