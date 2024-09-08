package com.example.todolist.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.model.ToDoText

@Dao
interface ToDoTextDao {
    @Query("SELECT * FROM ToDoText")
    fun getAll(): List<ToDoText>
    @Insert
    fun insert(toDoText: ToDoText)
    @Delete
    fun delete(toDoText: ToDoText)

}