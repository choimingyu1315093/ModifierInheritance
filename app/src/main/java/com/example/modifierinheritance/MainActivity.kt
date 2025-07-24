package com.example.modifierinheritance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifierinheritance.ui.theme.ModifierInheritanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier.fillMaxSize()
            ){
                InfoCard("첫번째")
                Spacer(modifier = Modifier.height(10.dp))
                InfoCard("두번째", modifier = Modifier.shadow(4.dp, RoundedCornerShape(8.dp)).background(Color.White))
                Spacer(modifier = Modifier.height(10.dp))
                InfoCard("세번째")
            }
        }
    }
}

@Composable
fun InfoCard(title: String, modifier: Modifier = Modifier){
    Column (
        modifier = modifier
    ){
        Text(
            text = title,
            modifier = Modifier.background(Color.Red).padding(20.dp).then(modifier)
        )
    }
}