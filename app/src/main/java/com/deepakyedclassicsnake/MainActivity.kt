package com.deepakyedclassicsnake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.deepakyedclassicsnake.ui.theme.ClassicSnakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClassicSnakeTheme {
                val viewModel = viewModel<SnakeGameViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()
                    SnakeGameScreen(
                        state = state,
                        onEvent = viewModel::onEvent
                    )
            }
        }
    }
}
