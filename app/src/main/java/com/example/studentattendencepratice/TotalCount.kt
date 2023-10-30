package com.example.studentattendencepratice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentattendencepratice.ui.theme.Bittersweet
import kotlin.random.Random
/*
@Composable
fun HomeScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_page") {
        composable("total_count"){
            clickTotalButton(navController = navController)
        }

        composable("gold_star") {
            clickGoldButton(navController = navController)
        }

        composable("random_student"){
            clickRandomButton(navController = navController)
        }
    }
}

@Composable
fun clickTotalButton(navController: NavController){
    Card(modifier = Modifier
        .height(220.dp)
        .width(200.dp)
        .background(color = Color.Yellow, shape = RectangleShape)
    ) {

        Button(modifier = Modifier
            //.padding(top = 30.dp)
            .height(120.dp)
            .width(100.dp),
            //.background(color = Color.Yellow, shape = RectangleShape) ,
            onClick = { navController.navigate("home_page") }) {
            Text(
                textAlign = TextAlign.Center,
                text = "Total Count",
            )
        }
        /*
        Surface(
            modifier = Modifier
                //.padding(top = 30.dp)
                .height(220.dp)
                .width(200.dp)
                .background(color = Color.Yellow, shape = RectangleShape)

        ) {
            Button(modifier = Modifier
                //.padding(top = 30.dp)
                .height(120.dp)
                .width(100.dp),
                //.background(color = Color.Yellow, shape = RectangleShape) ,
                onClick = { navController.navigate("home_page") }) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Total Count",
                )
            }
        }

         */
    }

}

@Composable
fun clickGoldButton(navController: NavController) {
    Surface(
        modifier = Modifier
            //.padding(top = 30.dp)
            .height(120.dp)
            .width(100.dp)
            .background(color = Color.Cyan, shape = RectangleShape)

    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Total Count",
        )
    }
    Button(onClick = { navController.navigate("home_page") }) {
        Text(
            textAlign = TextAlign.Center,
            text = "Gold Stars",
        )
    }
}

@Composable
fun clickRandomButton(navController: NavController){
    Surface(
        modifier = Modifier
            //.padding(top = 30.dp)
            .height(120.dp)
            .width(100.dp)
            .background(color = Color.Green, shape = RectangleShape)

    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Total Count",
        )
    }
    Button(onClick = { navController.navigate("home_page") }) {
        Text(
            textAlign = TextAlign.Center,
            text = "Random Student",
        )
    }
}


 */



@Composable
fun TotalDialog(studentList: ArrayList<StudentNames>) {
    var showDialog by remember { mutableStateOf(false) }
    Column {
        Button(onClick = { showDialog = true },
            shape =  RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Bittersweet),
            modifier = Modifier
                .padding(12.dp)
            ) {
            Text(text = "Student Count",
                fontSize = 25.sp,
                color = Color.White
                )
        }
    }
    if (showDialog) { Dialog(onDismissRequest = {showDialog = false}) {
            // Custom shape, background, and layout for the dialog
            Surface(
                modifier = Modifier
                    .height(590.dp)
                    .width(500.dp),
                //color = Color.Cyan,
                shape = RoundedCornerShape(16.dp),
            ) {
                Card(modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if(studentList.size == 25 /*The list is actually 23, but I am adding professor and a demo student*/){
                            Image(painter = painterResource(id = R.drawable.good_job),
                                contentDescription = "null"
                            )
                            Text(text = "Good Job!\uD83D\uDE04 \n All students are here.",
                                textAlign = TextAlign.Center,
                                fontSize = 40.sp,
                                modifier = Modifier.padding(top = 25.dp),
                                color = Color.Black,
                                lineHeight = 35.sp
                            )
                        } else {
                            Image(painter = painterResource(id = R.drawable.oip),
                                contentDescription = "null"
                            )
                            val missingStudents = 25 - studentList.size
                            Text(text = "Oh No! \uD83D\uDE1F \n There are $missingStudents students missing.",
                                textAlign = TextAlign.Center,
                                fontSize = 40.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(top = 25.dp),
                                lineHeight = 35.sp
                            )
                        }
                        Button(
                            onClick = { showDialog = false },
                            shape =  RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Bittersweet),
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Text("Close",
                                fontSize = 25.sp,
                                color = Color.White
                                )
                        }
                    }
                }

            }
        }
    }
}