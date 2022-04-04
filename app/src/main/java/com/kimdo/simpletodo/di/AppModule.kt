package com.kimdo.simpletodo.di

import android.content.Context
import androidx.room.Room
import com.kimdo.simpletodo.ShowDependent
import com.kimdo.simpletodo.db.TodoDao
import com.kimdo.simpletodo.db.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDatabase (@ApplicationContext context: Context) :TodoDatabase = Room.databaseBuilder(context, TodoDatabase::class.java, "Todo.db")
        .build()

    @Singleton
    @Provides
    fun provideTodoDao(todoDatabase: TodoDatabase): TodoDao = todoDatabase.todoDao()


    @Singleton
    @Provides
    fun provideXXX(): ShowDependent = ShowDependent("kimdo is good xxx is bad")
}