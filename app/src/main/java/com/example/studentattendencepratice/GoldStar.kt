package com.example.studentattendencepratice

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentattendencepratice.ui.theme.Amaranth
import com.example.studentattendencepratice.ui.theme.Bittersweet
import com.example.studentattendencepratice.ui.theme.Claret
import com.example.studentattendencepratice.ui.theme.Coral
import com.example.studentattendencepratice.ui.theme.Fawn
import com.example.studentattendencepratice.ui.theme.Purple80

@Composable
fun GoldStarHeader(navController: NavController){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(155.dp)
            .background(color = Claret, shape = RectangleShape)) {


        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 20.dp)
            ) {
            Text(
                text = "⭐⭐⭐ GOLD STARS ⭐⭐⭐",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
            )

            Button(onClick = { navController.navigate("home_page") },
                shape =  RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Bittersweet),
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Close",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }

}



@Composable
fun StudentGoldList (list: ArrayList<StudentNames>, navController: NavController) {
    Column {
        GoldStarHeader(navController =  navController)
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val sortedNumbers = list.sortedByDescending { students ->  students.count }
            for (students:StudentNames in sortedNumbers){

                item {
                    StudentGoldStars( studentNames = students)
                }
            }
        }
    }
}


@Composable
fun StudentGoldStars(studentNames: StudentNames) {
    Card(modifier = Modifier
        .padding(15.dp)
        .height(75.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            // change the name for the colors. They are stored in the colors.xml under resource value
            containerColor = colorResource(id = R.color.purple_200)
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RectangleShape
    )
    {
        StarAwards(studentNames = studentNames)
    }
}

@Composable
fun StarAwards(studentNames: StudentNames) {
    if(studentNames.count >= 3){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .border(3.dp, color = Claret, shape = RectangleShape)
                .background(color = Fawn, shape = RectangleShape),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = studentNames.names,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
               // This is how it is use with ui.theme colors :  color = Purple80,
                color = Color.Black,
                modifier = Modifier
                    .padding(15.dp)
            )

            Text(
                text = studentNames.count.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(15.dp)
                    .padding(end = 10.dp)
            )
        }
    }
    else if(studentNames.count > 0) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .border(3.dp, color = Claret, shape = RectangleShape)
                .background(color = Amaranth , shape = RectangleShape),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = studentNames.names,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                // This is how it is use with ui.theme colors :  color = Purple80,
                color = Color.Black,
                modifier = Modifier
                    .padding(15.dp)
            )

            Text(
                text = studentNames.count.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(15.dp)
                    .padding(end = 10.dp)
            )
        }
    }
    else {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .border(3.dp, color = Claret, shape = RectangleShape)
                .background(color = Coral, shape = RectangleShape),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = studentNames.names,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                // This is how it is use with ui.theme colors :  color = Purple80,
                color = Color.Black,
                modifier = Modifier
                    .padding(15.dp)
            )

            Text(
                text = studentNames.count.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(15.dp)
                    .padding(end = 10.dp)
            )
        }
    }
}