package com.example.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
     painter = painterResource(id = R.drawable.john_wick4),
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
        modifier = modifier.fillMaxSize(),
        elevation = 12.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize()

        ){
           Image(
               modifier=Modifier.fillMaxSize(),
               painter = painter, 
               contentDescription =contentDescription,
               contentScale = ContentScale.Crop
           )
            Box{
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ){
                    Icon(Icons.Filled.Close,
                        contentDescription ="close",
                        tint = Color.Black,
                        modifier= Modifier
                            .background(
                                Color.LightGray, CircleShape
                            )
                            .padding(4.dp)
                    )
                    Icon(
                        painterResource(id = R.drawable.baseline_bookmark_border_24),
                        contentDescription ="bookmark",
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.LightGray, CircleShape)
                        )
                }
            }
            Box(modifier= Modifier.align(Alignment.Center)){
                Icon(
                    painter = painterResource(id = R.drawable.ic_play) ,
                    contentDescription ="Play",
                    tint=Color.Black,
                    modifier = Modifier
                        .background(Color.LightGray, CircleShape)
                        .size(72.dp)
                        .padding(12.dp)
                        .align(Alignment.Center)
                    )
            }
            Box(modifier = Modifier
                .background(Brush.verticalGradient(
                    colors = listOf(Color.Transparent,Color.Black),
                    startY = 0.0f
                ))
            )
            
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .align(Alignment.BottomStart)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 10.0f
                    )
                ),
                contentAlignment = Alignment.BottomEnd,

            ){

                Column(modifier=Modifier
                    .clip(RoundedCornerShape(12.dp))){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "IDMB 6.8",
                            style= TextStyle(color= Color.Black,
                                fontSize=16.sp
                            ),
                            modifier= Modifier
                                .padding(end = 4.dp)
                                .background(Color.LightGray, RoundedCornerShape(12.dp))
                                .padding(4.dp)

                            )
                        Icon(Icons.Default.Star,
                            contentDescription ="rating" ,
                            tint = Color.White,
                            modifier=Modifier.padding(end = 4.dp)
                        )
                        Text(text=rating,
                            style= TextStyle(color= Color.White,
                                fontSize=16.sp))

                        Text("(118k reviews)",
                            style= TextStyle(color= Color.White,
                                fontSize=16.sp))

                    }
                    Text(
                        text = title,
                        style= TextStyle(color= Color.White,fontSize=24.sp)
                    )

                    LazyRow{
                        items(category.size){
                                cat ->
                            Text(text = category[cat], color= Color.Black,
                                modifier= Modifier
                                    .padding(4.dp)
                                    .background(
                                        Color.LightGray,
                                        RoundedCornerShape(12.dp)
                                    )
                                    .padding(4.dp))
                        }
                    }

                    Text(text=description,style= TextStyle(color= Color.White,fontSize=14.sp))
                    
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