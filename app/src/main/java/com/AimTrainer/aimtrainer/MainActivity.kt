package com.AimTrainer.aimtrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.MinHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.AimTrainer.aimtrainer.ui.theme.AimTrainerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AimTrainerTheme {
                    AppNavigation()
                }
            }
        }
    }

@Composable
fun HomeScreen(navController: NavHostController) {
    var name = remember {
        mutableStateOf("")
    }
    var timer = remember{
        mutableStateOf(0)
    }
    var grid = remember{
        mutableStateOf(0)
    }

    fun canStart(): Boolean{
        return name.value != "" && timer.value != 0 && grid.value != 0
    }

    fun getHomeDatas(): String{
        return "game/${name.value}/${timer.value}/${grid.value}/${navController}"
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(modifier = Modifier.padding(top = 60.dp, bottom = 15.dp), text = "AimTrainer", fontSize = 32.sp, color = Color(0xFF7F77DD))
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            placeholder = { Text("your name") },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(top = 20.dp, bottom = 30.dp, start = 45.dp, end = 45.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp),
            text = "time",
            color = Color(0xFF7F77DD),
            fontSize = 22.sp,
        )
        Row(modifier = Modifier.height(120.dp)) {
            Button(
                onClick = { timer.value = 15 },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (timer.value == 15) Color(0xFF7F77DD) else Color(0xFFEEEDFE),
                    contentColor = if (timer.value == 15) Color(0xFFEEEDFE) else Color(0xFF534AB7)
                )
            ) {
                Text("15s", fontSize = 16.sp)
            }
            Button(
                onClick = { timer.value = 30 },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (timer.value == 30) Color(0xFF7F77DD) else Color(0xFFEEEDFE),
                    contentColor = if (timer.value == 30) Color(0xFFEEEDFE) else Color(0xFF534AB7)
                )
            ){
                Text("30s", fontSize = 16.sp)
            }
            Button(
                onClick = { timer.value = 60 },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (timer.value == 60) Color(0xFF7F77DD) else Color(0xFFEEEDFE),
                    contentColor = if (timer.value == 60) Color(0xFFEEEDFE) else Color(0xFF534AB7)
                )
            ){
                Text("60s", fontSize = 16.sp)
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp),
            text = "Grid",
            color = Color(0xFF7F77DD),
            fontSize = 22.sp,
        )
        Row(modifier = Modifier.height(120.dp)) {
            Button(onClick = {grid.value = 9},
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (grid.value == 9) Color(0xFF7F77DD) else Color(0xFFEEEDFE),
                    contentColor = if (grid.value == 9) Color(0xFFEEEDFE) else Color(0xFF534AB7)
                )) {
                Text(text = "3x3")
            }

            Button(onClick = {grid.value = 16},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (grid.value == 16) Color(0xFF7F77DD) else Color(0xFFEEEDFE),
                    contentColor = if (grid.value == 16) Color(0xFFEEEDFE) else Color(0xFF534AB7)
                )) {
                Text(text = "4x4")
            }


            Button(onClick = {grid.value = 25},
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (grid.value == 25) Color(0xFF7F77DD) else Color(0xFFEEEDFE),
                    contentColor = if (grid.value == 25) Color(0xFFEEEDFE) else Color(0xFF534AB7)
                )) {
                Text(text = "5x5")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { navController.navigate(getHomeDatas()) },
            enabled = canStart(),
            modifier = Modifier.fillMaxWidth().height(52.dp),
            contentPadding = PaddingValues(vertical = 14.dp)
        ) {
            Text(text = "Start")
        }
    }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}