package com.AimTrainer.aimtrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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
        return "game/${name.value}/${timer.value}/${grid.value}"
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
        Text(text = "AimTrainer")
        TextField(
            placeholder = {Text(text = "Digite seu nome")},
            value = name.value,
            onValueChange = {name.value = it}
        )
        Row() {
            Button(onClick = {timer.value = 15}) {
                Text(text = "15s")
             }
            Button(onClick = {timer.value = 30}) {
                Text(text = "30s")
            }
            Button(onClick = {timer.value = 60}) {
                Text(text = "60s")
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row() {
            Button(onClick = {grid.value = 9}) {
                Text(text = "3x3")
            }
            Button(onClick = {grid.value = 16}) {
                Text(text = "4x4")
            }
            Button(onClick = {grid.value = 25}) {
                Text(text = "5x5")
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {navController.navigate(getHomeDatas())}, enabled = canStart()) {
            Text(text = "Start")
        }
    }
    }
}