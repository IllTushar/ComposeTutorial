package com.example.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Lazy Column
//            val data = Data()
//            LazyColumn(content = {
//                items(data) { category ->
//                    SingleRow(category = category)
//                }
//            })
//            PreView()
            val state = rememberSaveable {
                mutableStateOf(0)
            }
            Hoisting(state.value) { state.value++ }
        }
    }
}

@Composable
fun SayHi(name: String) {
    /* TextView
        Text(
            text = "Hello ${name}",
            color = Color.Blue,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
     */

    /*
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "DummyImage",
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.tint(Color.Blue)
    )
     */
    /*
    Button(onClick = {}) {
        Text(text = "Click")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Dummy",
            colorFilter = ColorFilter.tint(Color.Blue)
        )
    }
     */
    // TextField
    val state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value, onValueChange = {
        state.value = it
    }, label = { Text(text = "Enter Your Message") })

}

@Composable
fun ListItemView(imageId: Int, name: String, profile: String) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "DummyImage",
            modifier = Modifier.size(40.dp)
        )
        Column {
            Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = profile, fontSize = 16.sp, fontWeight = FontWeight.Thin)
        }
    }
}

@Preview(name = "Hello", showBackground = true, showSystemUi = true, widthDp = 350)
@Composable
private fun PreView() {
////    SayHi(name = "Tushar")
//    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.Start) {
//        ListItemView(
//            imageId = R.drawable.profile_icon,
//            name = "Tushar Gupta",
//            profile = "Android Developer"
//        )
//        ListItemView(
//            imageId = R.drawable.profile_icon,
//            name = "Shreyansh Gupta",
//            profile = "Android Developer"
//        )
//        ListItemView(
//            imageId = R.drawable.profile_icon,
//            name = "Nitika Gupta",
//            profile = "Android Developer"
//        )
//    }

    //Lazy Column
//    val data = Data()
//    LazyColumn(content = {
//        items(data) { category ->
//            SingleRow(category = category)
//        }
//    })


//    ReComposable()

    val state = rememberSaveable {
        mutableStateOf(0)
    }
    Hoisting(state.value) { state.value++ }
}

@Composable
fun ReComposable() {
    val state = remember {
        mutableStateOf(0.0)
    }
    Log.d("Main", "Initial Recomposition")
    Button(
        onClick = {
            state.value = Math.random()
        }
    ) {
        Log.d("Main", "After Initial")
        Text(text = state.value.toString())
    }
}


@Composable
fun Hoisting(value: Int, function: () -> Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This click ${value}")
        Button(onClick = { function() }) {
            Text(text = "Click Here!!")
        }
    }
}

