package com.mbialowas.composeintros249

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mbialowas.composeintros249.ui.theme.ComposeIntroS249Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeIntroS249Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // entry point into our application
                    Column {
                        Counter(modifier = Modifier.padding(innerPadding))
                        Switcher()
                        CustomList()
                    }

                }
            }
        }

    }
}
@Composable
fun Counter(modifier: Modifier = Modifier){
    var counter by remember{
        mutableStateOf(10)
    }

    Button(
         onClick = {
             counter += 1000
             Log.i("MJB", "Counter: $counter")
         }
    ){
        Text(text = "I've been clicked $counter times")
    }
}

@Composable
fun Switcher(){
    val checked = remember{
        mutableStateOf(false)
    }
    Column() {
        Switch(
            checked = checked.value,
            onCheckedChange = {
                checked.value = it
            }
        )
        if (checked.value){
            Text(text = "Switch is on")
        }else{
            Text(text = "Switch is off")
        }
    }

}
@Composable
fun CustomList(){
    val itemList = List(200){"Control $it"}
    LazyColumn{
        items(itemList){
            Text(text = it)
        }
    }

}

@Composable
fun  MyCheckbox(){
    var checked by remember {
        mutableStateOf(false)
    }

}



