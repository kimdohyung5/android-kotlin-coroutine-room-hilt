package com.kimdo.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimdo.simpletodo.databinding.ActivityMainBinding
import com.kimdo.simpletodo.databinding.DialogAddTodoBinding
import com.kimdo.simpletodo.db.TodoModel
import com.kimdo.simpletodo.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mTodoViewModel: TodoViewModel
    private lateinit var mTodoListAdapter: TodoListAdapter
    private lateinit var binding: ActivityMainBinding
    
    @Inject
    lateinit var showDate: ShowDate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
        initButtons()

        val name = showDate.showName()
        Log.d(TAG, "onCreate: ${name}")
    }
    private fun initRecyclerView() {
        mTodoListAdapter = TodoListAdapter()
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mTodoListAdapter
        }
    }

    private fun initViewModel() {
        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        mTodoViewModel.getTodoList().observe(this ) {
            Log.d(TAG, "initViewModel: todoItems is changed")
            mTodoListAdapter.setTodoItems(it)
        }
    }
    private fun initButtons() {
        binding.openDialog.setOnClickListener {
            openAddTodoDialog()
        }
    }

    private fun openAddTodoDialog() {
        val dailogBind :DialogAddTodoBinding = DialogAddTodoBinding.inflate(layoutInflater)

        AlertDialog.Builder(this)
            .setTitle("추가하기")
            .setView(dailogBind.root)
            .setPositiveButton("확인"){ dialogInterface, i ->
                val title = dailogBind.etTodoTitle.text.toString()
                val description = dailogBind.etTodoDescription.text.toString()
                val createdDate = Date().time
                val todoModel = TodoModel(null, title, description, createdDate)
                mTodoViewModel.insertTodo(todoModel)
            }
            .setNegativeButton("취소", null)
            .create()
            .show()
    }

    companion object {
        val TAG = "MainActivity"
    }

}