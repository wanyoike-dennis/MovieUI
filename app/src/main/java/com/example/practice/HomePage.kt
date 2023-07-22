package com.example.practice

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextOverflow
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
    val listOfMenuItems= listOf(
        BottomMenuContent("Home",R.drawable.ic_home),
        BottomMenuContent("Play",R.drawable.ic_play),
        BottomMenuContent("Profile",R.drawable.ic_profile)
    )

    Column(modifier = Modifier.fillMaxSize()
    ) {
        GreetingsSection()
        SearchArea()
        Categories(categories = listOfCategories)
        LatestMovieSection(
            text="Latest Movies",
            list = listOfMovies)
        LatestMovieSection(
            text="Popular Movies",
            list = listOfMovies)
        BottomMenu(item = listOfMenuItems
            )

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
fun Categories(categories:List<String>){
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
fun LatestMovieSection(text:String, list:List<Movie>){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ){
        BigTextCategory(text = text)
        LazyRow(){
            items(list.size){
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFE7F1F1))
                ){
                    Image(
                        painter =list[it].painter ,
                        contentDescription = list[it].title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                        )
                    Text(text = list[it].title,
                        overflow = TextOverflow.Ellipsis
                        )
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

@Composable
fun BottomMenu(
    item:List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightedColor: Color = Color(0xFFE7F1F1),
    activeTextColor: Color = Color.White,
    inactiveTextColor:Color = Color.Transparent,
    initialSelectedItemIndex : Int = 0
){

    var selectedItemIndex by remember{
        mutableStateOf(initialSelectedItemIndex)
    }


    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(10.dp))
    ){
        item.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightedColor=activeHighlightedColor,
                activeTextColor= activeTextColor,
                inactiveTextColor=inactiveTextColor
            ){
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item:BottomMenuContent,
    isSelected:Boolean =false,
    activeHighlightedColor:Color = Color.Blue,
    activeTextColor:Color = Color.Gray,
    inactiveTextColor:Color = Color.Black,
    onItemClick:() -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable { onItemClick }
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightedColor else Color.Transparent)
                .padding(10.dp)

        ){
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint= if(isSelected) activeTextColor else Color.Transparent,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
        color= if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}
@Preview(showBackground =true)
@Composable
fun HomePagePreview(){
    HomePage()
}