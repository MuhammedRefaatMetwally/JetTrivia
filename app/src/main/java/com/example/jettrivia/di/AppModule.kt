package com.example.jettrivia.di

import com.example.jettrivia.network.QuestionApis
import com.example.jettrivia.repository.QuestionRepository
import com.example.jettrivia.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionsApis() : QuestionApis{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApis::class.java)
    }

    @Singleton
    @Provides
    fun provideQuestionsRepository(api : QuestionApis)  = QuestionRepository(api)

}