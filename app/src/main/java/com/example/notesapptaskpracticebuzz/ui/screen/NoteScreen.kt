package com.example.notesapptaskpracticebuzz.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun NoteScreen(navController: NavController) {
    var notes by remember {
        mutableStateOf(listOf("Practice Buzz", "Android Development Task"))
    }
    var addNewNote by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(top = 100.dp,start = 10.dp)) {
        Text(text = "Simple note App", fontSize = 20.sp, modifier = Modifier.padding(12.dp))
        BasicTextField(value = addNewNote, onValueChange = {
            addNewNote = it
        },
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .border(2.dp, Color.Black)
                .padding(10.dp)

        )
        Button(
            onClick = {
                notes = notes + addNewNote
                addNewNote = ""
            },


        ) {
            Text(text = "Click me to Add Note", color = Color.White)
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(notes.size) {
                Text(
                    text = notes[it], fontSize = 20.sp,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("NoteDetailScreen/${notes[it]}")
                        }
                )


            }
        }

    }

}

