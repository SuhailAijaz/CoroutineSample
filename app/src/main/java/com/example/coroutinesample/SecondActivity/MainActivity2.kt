package com.example.coroutinesample.SecondActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesample.R
import com.example.coroutinesample.SecondActivity.network2ndAct.CommentInstance
import com.example.coroutinesample.SecondActivity.network2ndAct.CommentsDataClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {

    private val adapterClass by lazy {
        AdapterClass()
    }
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = "RecyclerView"
        recyclerView = findViewById(R.id.recyclerView)




        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity2)
            adapter = adapterClass
        }


        lifecycleScope.launch() {
            val apidata = withContext(Dispatchers.IO) {
                CommentInstance.getCommentsService().getData()

            }

            if (apidata.isSuccessful) {
                adapterClass.receiveData(apidata.body() ?: CommentsDataClass())
            }
        }


    }
}