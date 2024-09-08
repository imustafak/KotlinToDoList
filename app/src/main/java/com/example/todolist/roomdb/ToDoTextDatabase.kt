package com.example.todolist.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.model.ToDoText

@Database (entities = [ToDoText::class], version = 1)
abstract class ToDoTextDatabase : RoomDatabase() {
    abstract fun toDoTextDao(): ToDoTextDao
}