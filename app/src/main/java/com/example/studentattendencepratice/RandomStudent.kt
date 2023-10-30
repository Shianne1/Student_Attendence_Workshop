package com.example.studentattendencepratice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.studentattendencepratice.ui.theme.Bittersweet
import com.example.studentattendencepratice.ui.theme.Claret
import kotlin.random.Random

@Composable
fun StudentDialog(studentList: ArrayList<StudentNames>) {
    val nameList = ArrayList<String>()
    var showDialog by remember { mutableStateOf(false) }
    Column {
        Button(onClick = { showDialog = true },
            shape =  RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Bittersweet),
            modifier = Modifier
                .padding(12.dp)
            ) {
            Text(text = "Random Student",
                fontSize = 25.sp,
                color = Color.White
                )
        }
    }
    if (showDialog) {
        Dialog(onDismissRequest = {showDialog = false}) {
            // Custom shape, background, and layout for the dialog
            Surface(
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TeamK9()
                    for(s in studentList){
                        nameList.add(s.names)
                    }
                    val random = Random.nextInt(nameList.size);
                    val randomStudents = nameList[random]
                    Text(text = "$randomStudents",
                        fontSize = 35.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
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

/*
@Composable

fun s(studentList: ArrayList<StudentNames>, onClick: () -> Unit){
Button(onClick = onClick,
    ){
    Text(text = "Testing")
}
}
@Composable
fun d(){
    val list = listOf("hello", "pie", "love", "do", "bike")
    val randomIndex = Random.nextInt(list.size);
    val randomElement = list[randomIndex]
    Text("Random Student: $randomElement")

}

 */

@Composable
fun TeamK9(){
    var showDialog by remember { mutableStateOf(1) }
    val names = when(showDialog) {
        1 -> "Julian Ellis"
        2 -> "Chloe Jackson"
        3 -> "Abdoulie Njie"
        4 -> "Connor Murdock"
        else -> "Shianne Lesure"
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = names,
            fontSize = 35.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
            )
        Button(onClick = { showDialog = (1..5).random() },
            shape =  RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Claret),
            modifier = Modifier.padding(top = 16.dp)
            ) {
            Text(text = "TeamK9",
                fontSize = 25.sp,
                color = Color.White
                )
        }
    }
}
