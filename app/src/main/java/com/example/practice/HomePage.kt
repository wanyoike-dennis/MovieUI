package com.example.practice

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomePage(){
    val listOfCategories = listOf(
        "Action","Comedy","Romance","Sci-Fiction","Documentary","Bl"
    )
    val listOfMovies= listOf(
        Movie(painterResource(id = R.drawable.bad_habits),"Bad Habits"),
        Movie(painterResource(id = R.drawable.intermediate_dev),"Intermediate Devs"),
        Movie(painterResource(id = R.drawable.kmm),"KMM"),
        Movie(painterResource(id = R.drawable.learn_coding_fast),"Learn coding fast"),
        Movie(painterResource(id = R.drawable.master_logical_thinking),"Master logical thinking"),
        Movie(painterResource(id = R.drawable.multiple_languages),"Multiple Languages"),
    )
    Column(modifier = Modifier.fillMaxSize()) {
        GreetingsSection()
        Spacer(modifier = Modifier.height(4.dp))
        SearchArea()
        Spacer(modifier = Modifier.height(4.dp))
        Categories(categories = listOfCategories)
        LatestMovieSection(list = listOfMovies)
    }
}

@Composable
fun GreetingsSection(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement= Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
           Text(
               text = "Welcome Dennis",
               style = MaterialTheme.typography.h2,
               fontSize = 18.sp
               ) 
            Text(
                text ="Let's relax and watch a movie!",
                style= MaterialTheme.typography.h2,
                fontSize=20.sp,
                fontWeight = FontWeight.Bold
            )
            
        }
        Image(
            painter = painterResource(id =R.drawable.img),
            contentDescription = "profile image",
            contentScale= ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .clip(CircleShape)
            )
    }
}

@Composable
fun SearchArea(){
    var (value,onValueChange) = remember {
        mutableStateOf("")
    }
   Column(
       verticalArrangement = Arrangement.Center,
       modifier= Modifier
           .fillMaxWidth()
           .padding(12.dp)
   ) {
       TextField(
           value= value,
           onValueChange = {onValueChange},
           modifier = Modifier
               .fillMaxWidth()
               .background(
                   Color(0xFFE7F1F1),
                   RoundedCornerShape(16.dp)
               ),
           leadingIcon = {Icon(Icons.Filled.Search , null,tint=Color.Gray)},
           placeholder = {Text(text= "Search for a movie ")},
           colors= TextFieldDefaults.textFieldColors(
               focusedIndicatorColor = Color.Transparent,
               unfocusedIndicatorColor = Color.Transparent,
               backgroundColor = Color.Transparent,
               cursorColor = Color.DarkGray
           )
       )


   }
}

@Composable
fun Categories(
    categories:List<String>
){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
        BigTextCategory(text = "Categories")
        LazyRow(

        ){
            items(categories.size) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp)
                ){
                    Text(
                        text= categories[it],
                        modifier = Modifier
                            .padding(8.dp)
                            .background(
                                Color(0xFFE7F1F1),
                                RoundedCornerShape(16.dp)
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun LatestMovieSection(list:List<Movie>){
    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ){
        BigTextCategory(text = "Latest Movie")
        LazyRow(){
            items(list.size){
                Column(){
                    Image(
                        painter =list[it].painter ,
                        contentDescription = list[it].title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                        )
                    Text(text = list[it].title)
                }
            }
        }
    }
}

@Composable
fun BigTextCategory(text:String){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier= Modifier.fillMaxWidth()) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text ="View all",
            fontStyle = FontStyle.Italic,
            color= Color.Magenta
        )
    }
}

@Preview(showBackground =true)
@Composable
fun HomePagePreview(){
    HomePage()
}