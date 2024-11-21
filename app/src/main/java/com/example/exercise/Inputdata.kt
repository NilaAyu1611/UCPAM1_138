package com.example.exercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun Inputdata(modifier: Modifier = Modifier){
    var keberangkatan by remember { mutableStateOf("") }
    var kedatangan by remember { mutableStateOf("") }
    var tanggalbrk by remember { mutableStateOf("") }
    var tanggaldtg by remember { mutableStateOf("") }
    var Class by remember { mutableStateOf("") }

    var dataClass = listOf("Ekonomi", "Bussiness")

    var confkeberangkatan by remember { mutableStateOf("") }
    var confkedatangan by remember { mutableStateOf("") }
    var conftanggalbrk by remember { mutableStateOf("") }
    var conftanggaldtg by remember { mutableStateOf("") }
    var confClass by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxWidth()){
        Box(){
            Column (modifier = modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ){
                datail()

                TextField(
                    value = kedatangan,
                    onValueChange = {kedatangan=it},
                    label = {
                        Text(text = "Kedatangan" )
                    },
                    placeholder = {
                        Text(text = "Isi lokasi kdatangan anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                )

                TextField(
                    value = keberangkatan,
                    onValueChange = {keberangkatan=it},
                    label = {
                        Text(text = "Keberangkatan" )
                    },
                    placeholder = {
                        Text(text = "Isi lokasi keberangkatan anda")
                    },
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                )
                Row(modifier = modifier.fillMaxWidth()) {
                    TextField(
                        value = tanggalbrk,
                        onValueChange = {tanggalbrk=it},
                        label = {
                            Text(text = "Tanggalbrk" )
                        },
                        placeholder = {
                            Text(text = "Isi ")
                        },
                        modifier = Modifier.fillMaxWidth().weight(0.2f))

                    TextField(
                        value = tanggaldtg,
                        onValueChange = {tanggaldtg=it},
                        label = {
                            Text(text = "Tanggaldtg" )
                        },
                        placeholder = {
                            Text(text = "Isi ")
                        },
                        modifier = Modifier.fillMaxWidth().weight(0.2f))


                }

                Row (modifier = modifier.fillMaxWidth()){
                    dataClass.forEach{selectedClass ->
                        Row(verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = Class == selectedClass,
                                onClick = {Class = selectedClass}
                            )
                            Text(text = selectedClass)}
                    }
                }

                Button(onClick = {
                    confkeberangkatan = keberangkatan
                    confkedatangan = kedatangan
                    conftanggalbrk = tanggalbrk
                    conftanggaldtg = tanggaldtg
                    confClass = Class
                }){
                    Text(text = "Submit")
                }

                Row {
                    Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                        Column(modifier = Modifier.fillMaxWidth().background(Color.Gray)){
                            detail(param = "Keberangkatan", argu = confkeberangkatan)
                            detail(param = "Kedatanagn", argu = confkedatangan)
                            detail(param = "Tanggalbrk", argu = conftanggalbrk)
                            detail(param = "Tanggaldtg", argu = conftanggaldtg)
                            detail(param = "Class", argu = confClass)
                        }

                        Image(painter = painterResource(id = R.drawable.kai),
                            contentDescription = null,
                            modifier = Modifier.clip(CircleShape)
                        )

                    }


                }
        }



        }
    }


}



@Composable
fun datail() {

        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {

            Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Good Afternoon")
                        Text(text = "Indra Al Fauzan")

            }

            Icon(
                Icons.Filled.Notifications,
                contentDescription = null,
                modifier = Modifier.size(30.dp))


        }
}


@Composable
fun detail(param :String, argu : String) {
    Box() {
        Column() {
            Row() {
                Text(
                    text = param,
                    modifier = Modifier.weight(0.9f)
                )
                Text(
                    text = "👉",
                    modifier = Modifier.weight(0.9f)
                )
                Text(
                    text = argu,
                    modifier = Modifier.weight(0.9f)
                )


            }

        }
    }
}


