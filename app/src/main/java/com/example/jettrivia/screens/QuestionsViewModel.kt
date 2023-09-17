package com.example.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.model.QuestionsItem
import com.example.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val questionRepository: QuestionRepository) : ViewModel() {
    val data : MutableState<DataOrException<ArrayList<QuestionsItem>,Boolean,Exception>> =
        mutableStateOf(
            DataOrException(null , true , Exception(""))
        )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = questionRepository.getAllQuestions()
            if(data.value.toString().isNotEmpty()) data.value.loading = false

        }
    }

    fun getAllQuestionsCount(): Int {
        return data.value.data?.size!!
    }
}