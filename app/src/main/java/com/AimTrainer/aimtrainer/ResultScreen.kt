package com.AimTrainer.aimtrainer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Result(name: String, timer: Int, score: Int) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Text(text = name, )
            Text(text = timer.toString())
            Text(text = score.toString())
    }
}
    }

@Preview
@Composable
fun ResultPreview() {
    Result("test", 15, 15)
}