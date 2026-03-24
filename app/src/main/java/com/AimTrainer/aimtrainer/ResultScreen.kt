package com.AimTrainer.aimtrainer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlin.math.sqrt

@Composable
fun Result(name: String, timer: Int, grid: Int, score: Int, navController: NavController) {
    val gridSize = sqrt(grid.toFloat()).toInt()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF3C3489)
            )
            Spacer(Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .size(140.dp)
                    .background(
                        color = Color(0xFF7F77DD),
                        shape = RoundedCornerShape(24.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = score.toString(),
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFEEEDFE)
                    )
                    Text(
                        text = "pontos",
                        fontSize = 16.sp,
                        color = Color(0xFFAFA9EC)
                    )
                }
            }
            Spacer(Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(72.dp)
                        .background(Color(0xFFEEEDFE), RoundedCornerShape(16.dp))
                        .border(BorderStroke(1.5.dp, Color(0xFFAFA9EC)), RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "tempo", fontSize = 13.sp, color = Color(0xFF9B96D4))
                        Text(
                            text = "${timer}s",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF3C3489)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(72.dp)
                        .background(Color(0xFFEEEDFE), RoundedCornerShape(16.dp))
                        .border(BorderStroke(1.5.dp, Color(0xFFAFA9EC)), RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "grid", fontSize = 13.sp, color = Color(0xFF9B96D4))
                        Text(
                            text = "${gridSize}×${gridSize}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF3C3489)
                        )
                    }
                }
            }

            Spacer(Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.navigate("game/$name/$timer/$grid/$navController") {
                        popUpTo("game/$name/$timer/$grid/$navController") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7F77DD))
            ) {
                Text(text = "play again", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color.White)
            }
            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                border = BorderStroke(1.5.dp, Color(0xFFAFA9EC)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF3C3489))
            ) {
                Text(text = "home", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Preview
@Composable
fun ResultPreview() {
    Result(name = "Viktor", timer = 15, grid = 16, score = 24, navController = rememberNavController())
}