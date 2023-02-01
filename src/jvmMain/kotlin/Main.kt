// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowSize
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = remember { MainViewModel() }
        val items = remember { viewModel.items }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Релизы",
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(
                                color = Color.LightGray,
                                shape = RoundedCornerShape(100.dp)
                            ).clickable {
                                viewModel.addItem(ReleaseItem(title = "Релиз 14.0", description = "Фича фриз: 20.02.2023   ПСИ: 20.02.2023     Релиз: 20.02.2023"))
                            }
                            .padding(16.dp)
                    ){
                        Text(text = "+ Добавить релиз")
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
                LazyColumn {
                    items(items) { releaseItem ->
                        ReleaseItemComponent(releaseItem)
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                }
            }
        }
    }
}

fun main() = application {
    val windowState = rememberWindowState()
    windowState.size = DpSize(1500.dp, 1000.dp)
    Window(title = "Релизная  доска", state = windowState, onCloseRequest = ::exitApplication) {
        App()
    }
}
