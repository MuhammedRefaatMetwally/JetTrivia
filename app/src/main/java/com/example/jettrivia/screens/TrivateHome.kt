package com.example.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettrivia.component.QuestionsView

@Composable
fun TriviaHome(viewModel : QuestionsViewModel = hiltViewModel()) = QuestionsView(viewModel = viewModel )
