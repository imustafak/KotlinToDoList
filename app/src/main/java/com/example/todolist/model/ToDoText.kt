package com.example.todolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ToDoText (@ColumnInfo(name = "text") var text: String){
    @PrimaryKey(autoGenerate = true)
    var id = 0

}