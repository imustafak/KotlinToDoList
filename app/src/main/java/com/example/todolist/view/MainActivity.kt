package com.example.todolist.view

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.todolist.R
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.ToDoText
import com.example.todolist.roomdb.ToDoTextDao
import com.example.todolist.roomdb.ToDoTextDatabase

class MainActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Int>()
    private var count = 0
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private lateinit var db: ToDoTextDatabase
    private lateinit var toDoTextDao: ToDoTextDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        recyclerViewAdapter = RecyclerViewAdapter(itemList)
        binding.recyclerView.adapter = recyclerViewAdapter
        db = Room.databaseBuilder(applicationContext, ToDoTextDatabase::class.java, "ToDoTexts").build()
        toDoTextDao = db.toDoTextDao()

    }
    fun addButtonOnClick(view : View)
    {



        itemList.add(count)
        count++
        recyclerViewAdapter?.notifyDataSetChanged()
        System.out.println(itemList.size)
        val editText = findViewById<EditText>(R.id.editTextText)
        val toDoText = ToDoText(editText.text.toString())
        toDoTextDao.insert(toDoText)
        System.out.println(toDoTextDao.getAll())

    }
}