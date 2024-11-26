package com.yunpnzr.afapartmentapp.presentation.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yunpnzr.afapartmentapp.R
import com.yunpnzr.afapartmentapp.common.component.InputUnderlineCustom
import com.yunpnzr.afapartmentapp.common.ui.theme.AppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(LocalConfiguration.current.screenHeightDp.dp * 1 / 4)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF01367A),
                                Color(0xFF0263E0)
                            )
                        )
                    )
            ) {
                HeaderHomeScreen(
                    Modifier.padding(16.dp)
                )
            }
            /*BoxInputScreen(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .align(Alignment.BottomCenter),
                navController = navController
            )*/
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .offset(y = (LocalConfiguration.current.screenHeightDp.dp * 1 / 8)) // Mengatur posisi vertikal
                    .fillMaxWidth()
            ) {
                BoxInputScreen(
                    modifier = Modifier.fillMaxWidth(),
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun HeaderHomeScreen(
    modifier: Modifier = Modifier,

){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(
                    width = 52.dp,
                    height = 34.dp
                ),
            painter = painterResource(R.drawable.ic_home_logo),
            contentDescription = "Logo"
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Box(
            modifier = Modifier
        ) {
            Icon(
                modifier = Modifier,
                painter = painterResource(R.drawable.ic_notification_outline),
                contentDescription = "Notification",
                tint = Color.White
            )
            Text(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(
                        Color.Red,
                        shape = RoundedCornerShape(50)
                    ),
                text = "1",
                color = Color.White,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun BoxInputScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){

    var search by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    bottom = 16.dp,
                    start = 24.dp,
                    end = 24.dp
                ),
            text = "Hi Budi!",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 16.dp,
                    start = 24.dp,
                    end = 24.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search"
            )
            InputUnderlineCustom(
                modifier = Modifier
                    .padding(
                        start = 8.dp
                    ),
                placeholder = "Cari nama apartemen",
                valueInput = search,
                onValueChange = {
                    search = it
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 16.dp,
                    start = 24.dp,
                    end = 24.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(R.drawable.ic_calendar),
                contentDescription = "Calendar"
            )
            InputUnderlineCustom(
                modifier = Modifier
                    .padding(
                        start = 8.dp
                    ),
                placeholder = "Masukkan tanggal pemesanan",
                valueInput = date,
                onValueChange = {
                    date = it
                }
            )
        }

        Button(
            modifier = Modifier
                //.fillMaxWidth()
                .padding(
                    top = 16.dp,
                    bottom = 24.dp,
                    /*start = 16.dp,
                    end = 16.dp*/
                ),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = {

            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF01367A),
                                Color(0xFF0263E0)
                            )
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        vertical = 8.dp
                    )
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    text = "Cari"
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    AppTheme {
        HomeScreen(navController = rememberNavController())
    }
}

/*
@Composable
@Preview(showBackground = true)
fun BoxInputScreenPreview(){
    AppTheme {
        BoxInputScreen(navController = rememberNavController())
    }
}
*/

/*
@Composable
@Preview(showBackground = true)
fun HeaderHomeScreenPreview() {
    AppTheme {
        HeaderHomeScreen()
    }
}*/
