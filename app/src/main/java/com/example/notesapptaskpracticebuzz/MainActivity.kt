package com.example.notesapptaskpracticebuzz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapptaskpracticebuzz.ui.screen.NoteDetailScreen
import com.example.notesapptaskpracticebuzz.ui.screen.NoteScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "NoteScreen"){
                composable("NoteScreen"){
                    NoteScreen(navController)

                }
                composable("NoteDetailScreen/{noteId}"){
                    backStackEntry ->
                    val note = backStackEntry.arguments?.getString("noteId")?:""
                  NoteDetailScreen( note = note)
                }
            }

        }
    }
}
