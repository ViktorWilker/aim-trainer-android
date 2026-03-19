package com.AimTrainer.aimtrainer.ui.theme

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen(name: String, timer: Int, grid: Int) {
    val activeBalls = 2
    val gridValues = kotlin.math.sqrt(grid.toFloat()).toInt()
    val cells = remember {mutableStateListOf<Boolean>().also {List -> repeat(grid){List.add(false)}}}
    fun spawnTargets(){
        val indices = cells.indices.filter { cells[it] == false }
        val randomIndex = indices.random()
        cells[randomIndex] = true
    }

    LaunchedEffect(Unit) {
        spawnTargets()
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize() ) {
            repeat(gridValues) {
                Row() {
                    repeat(gridValues) {
                        Box(modifier = Modifier.weight(1f).aspectRatio(1f).padding(3.dp)) {
                        }
                    }
                }
            }
        }
    }


}