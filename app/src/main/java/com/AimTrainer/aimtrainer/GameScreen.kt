package com.AimTrainer.aimtrainer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlin.math.sqrt

@Composable
fun GameScreen(name: String, timer: Int, grid: Int, navController: NavController) {
    val activeBalls = 2
    val gridValues = sqrt(grid.toFloat()).toInt()
    val cells = remember {mutableStateListOf<Boolean>().also {List -> repeat(grid){List.add(false)}}}
    val score = remember { mutableIntStateOf(0) }
    val timerLeft = remember{mutableIntStateOf(timer)}
    val gameStart = remember {mutableStateOf(false)}
    val countToStart = remember {mutableStateOf(0)  }

    fun spawnTargets(count: Int = 1){
        repeat(count){
        val indices = cells.indices.filter { cells[it] == false }
        val randomIndex = indices.random()
        cells[randomIndex] = true}
    }

    LaunchedEffect(Unit) {
        for(i in 3 downTo 1){
            countToStart.value = i
            delay(1000)
        }
        gameStart.value = true
        countToStart.value = 0

        spawnTargets(3)
        while (timerLeft.intValue > 0){
            delay(1000)
            timerLeft.intValue--
        }

        navController.navigate("result/$name/$timer/${score.intValue}")
    }

    fun addNewTarget(value: Int = 0){
        spawnTargets(1)
        cells[value] = false
        score.intValue += 1
    }

    @Composable
    fun prepareToStart(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "${countToStart.value}")
        }
    }

    if(!gameStart.value){
        prepareToStart()
    }else{
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding).fillMaxSize(), ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(modifier = Modifier.weight(1f), text = name, textAlign = TextAlign.Start)
                    Text(modifier = Modifier.weight(1f), text = "${timerLeft.intValue}", textAlign = TextAlign.Center)
                    Text(modifier = Modifier.weight(1f), text = "${score.intValue}", textAlign = TextAlign.End)
                }
                repeat(gridValues) { row->
                    Row() {
                        repeat(gridValues) { col ->
                            Box(modifier = Modifier.weight(1f).aspectRatio(1f).padding(3.dp)) {
                                var x = row * gridValues + col
                                if(cells[x] == true){
                                    Button(
                                        modifier = Modifier.fillMaxSize(),
                                        onClick = {addNewTarget(x)},
                                        shape = ButtonDefaults.shape,
                                        colors = ButtonDefaults.buttonColors(Color.Red)
                                    ) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
