package com.example.studentattendencepratice

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentattendencepratice.ui.theme.Amaranth
import com.example.studentattendencepratice.ui.theme.Bittersweet
import com.example.studentattendencepratice.ui.theme.Claret
import com.example.studentattendencepratice.ui.theme.Coral

/*

@Composable
fun Header( name: String){
    Row(
        modifier = Modifier
            // wraps completely around the text
            .wrapContentSize(Alignment.TopCenter, false)
            //fills it to hit the edge of the device
            .fillMaxWidth()
            .height(80.dp)
            .background(color = colorResource(id = R.color.purple_500), shape = RectangleShape)) {

        Surface(
            shape = RectangleShape,
            modifier = Modifier
                // wraps completely around the text
                .wrapContentSize(Alignment.TopCenter, false)
                //fills it to hit the edge of the device
                .size(width = 490.dp, height = 70.dp)
                .padding(top = 20.dp, bottom = 10.dp, start = 15.dp, end = 10.dp)
        ){
            Text(
                text = name,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 8.dp, start = 5.dp)
            )
        }

    }

}

 */

@Composable
fun ImageHeader() {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
            shape = RectangleShape) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner3),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                    .fillMaxWidth()
                )
            }
        }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StudentList (list: ArrayList<StudentNames>,sort: ArrayList<SortingNames>, paddingValues: PaddingValues) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues)
    ) {
        val sortLetters = sort.sortedBy { sortingNames -> sortingNames.letter }
        for(sortingNames: SortingNames in sortLetters){
            stickyHeader { LetterCard(sortingNames = sortingNames) }
            val sortStudents = list.sortedBy { students -> students.names }
            for (students:StudentNames in sortStudents){
                if(students.names.first().toString().equals(sortingNames.letter, true)){
                    item {
                        StudentCard(studentNames = students)
                    }
                }
            }
        }
    }
}

@Composable
fun LetterCard(sortingNames: SortingNames) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .border(3.dp, color = Claret, shape = RectangleShape),
        colors = CardDefaults.cardColors(containerColor = Amaranth),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RectangleShape
    )
    {
        Text(
            text = sortingNames.letter.uppercase(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(15.dp)
                .align(alignment = Alignment.Start)
        )

    }
}

@Composable
fun StudentCard(studentNames: StudentNames) { // Stateless counter
    Card(modifier = Modifier
        .padding(15.dp)
        .border(3.dp, color = Claret, shape = RectangleShape)
        .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Coral),
        shape = RectangleShape
    )
    {
        Text(
            text = studentNames.names,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(25.dp)
                .align(alignment = Alignment.Start)
        )
    }
}

/*
@Composable
fun Stateless( onIncrement: () -> Unit) {
    //val count = studentNames.count
    Button(onClick = onIncrement
    /*{ addStar += 1 } */) {
        Text(
            textAlign = TextAlign.Center,
            text = "Total Count",
        )
    }
}
@Composable
fun Stateful (studentNames: StudentNames){ //stateful counter
    var addStar by rememberSaveable { mutableIntStateOf(studentNames.count) }
    Stateless { addStar++ }

}

 */
