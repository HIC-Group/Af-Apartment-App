package com.yunpnzr.afapartmentapp.presentation.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yunpnzr.afapartmentapp.R
import com.yunpnzr.afapartmentapp.common.component.InputUnderlineCustom
import com.yunpnzr.afapartmentapp.common.ui.theme.AppTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        BoxInput(navController = navController)
    }
}

@Composable
fun BoxInput(
    modifier: Modifier = Modifier,
    navController: NavHostController
){

    var search by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
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
                    top = 8.dp,
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
            text = "Hi Budi!",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 8.dp
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
                placeholder = "Search",
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
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 8.dp
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
                placeholder = "Date",
                valueInput = date,
                onValueChange = {
                    date = it
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    AppTheme {
        HomeScreen(navController = rememberNavController())
        BoxInput(navController = rememberNavController())
    }
}