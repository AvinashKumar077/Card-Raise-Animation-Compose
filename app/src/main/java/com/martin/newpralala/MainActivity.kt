package com.martin.newpralala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martin.newpralala.ui.theme.NewPralalaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewPralalaTheme {
                CitySelectionScreen()
            }
        }
    }
}

@Composable
fun CitySelectionScreen() {
    var selectedCityIndex by remember { mutableIntStateOf(-1) } // Track selected city index
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(
            colors = listOf(Color(0xffF0F5FF), Color(0xffFFFFFF))
        )),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(5) { index ->
            EffectCard(
                isSelected = index == selectedCityIndex,
                onSelect = { selectedCityIndex = index }
            )
        }
    }
}