package com.example.jettrivia.repository

import android.util.Log
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.model.QuestionsItem
import com.example.jettrivia.network.QuestionApis
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val questionApis: QuestionApis){

    private  val dataOrException = DataOrException<ArrayList<QuestionsItem>, Boolean , Exception>()

    suspend fun getAllQuestions() : DataOrException<ArrayList<QuestionsItem> , Boolean , Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = questionApis.getAllQuestion()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        }catch (exception : Exception){
          dataOrException.e = exception
            Log.d("exc" , "getAllQuestions:${dataOrException.e!!.localizedMessage}")
        }
        return  dataOrException
    }
}