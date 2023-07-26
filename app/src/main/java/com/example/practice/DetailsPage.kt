package com.example.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsPage(){
 ImageCard(
     painter = painterResource(id = R.drawable.bad_habits),
     contentDescription = "picture",
     title = "Fast-X" ,
     rating = "6.8",
     category = listOf("Action","Sci-Fi","Time travel"),
     description = "Thor:Love and thunder is a 2022 America \n" 
 +"superhero film based on Marvel Comics featuring the character \n"
 +"Thor. produced by Marvel Studios and distributed by Walt disney"
 )
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription:String,
    title:String,
    rating:String,
    category:List<String>,
    description:String,
    modifier:Modifier = Modifier
){
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier,
        ){
           Image(
               painter = painter, 
               contentDescription =contentDescription,
               contentScale = ContentScale.Crop
           ) 
            Box(modifier = Modifier
                .background(Brush.verticalGradient(
                    colors = listOf(Color.Transparent,Color.Black),
                    startY = 300f
                ))
            )
            
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(
                    text = title,
                    style= TextStyle(color= Color.White,fontSize=16.sp)
                    )
                Text(text=rating)
                LazyRow{
                    items(category.size){
                        cat ->
                        Text(text = category[cat])
                    }
                }
                
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPagePreview(){
    DetailsPage()
}