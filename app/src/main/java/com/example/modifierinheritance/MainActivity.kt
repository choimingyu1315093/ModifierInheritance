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
                InfoCard("세번째", modifier = Modifier.shadow(10.dp, RoundedCornerShape(20.dp)).background(Color.Blue))
            }
        }
    }
}

//아무런 속성도 넣지 않음
//@Composable
//fun InfoCard(title: String){
//    Column { //상위 컴포저블
//        Text( //하위 컴포저블
//            text = title
//        )
//    }
//}

//하위 컴포저블에 속성 추가
//@Composable
//fun InfoCard(title: String){
//    Column {
//        Text(
//            modifier = Modifier.background(Color.Red).padding(20.dp),
//            text = title
//        )
//    }
//}


//InfoCard를 다 만들고 사용하려고 하는데, 두번째 InfoCard의 모서리를 둥글게 바꾸고 싶어
//그러면 InfoCard2 뭐 이런식으로 만들어? 만약 이런게 100개라면?
//그래서 상위 컴포저블에서 하위 컴포저블로 Modifier를 전달하는게 중요하다. 재사용성이 향상 된다.


//Modifier 전달
//@Composable
//fun InfoCard(title: String, modifier: Modifier = Modifier){
//    Column (
//        modifier = modifier
//    ){
//        Text(
//            modifier = Modifier.background(Color.Red).padding(20.dp),
//            text = title
//        )
//    }
//}

//이렇게 다 만들고 보니 두번째 InfoCard의 텍스트 배경을 흰색으로 바꾸고 싶어졌다.
@Composable
fun InfoCard(title: String, modifier: Modifier = Modifier){
    Column (
        modifier = modifier
    ){
        Text(
            modifier = Modifier.background(Color.Red).padding(20.dp).then(modifier),
            text = title
        )
    }
}