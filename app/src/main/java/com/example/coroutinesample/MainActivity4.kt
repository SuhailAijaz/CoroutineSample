package com.example.coroutinesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesample.Forth.UsersInstance
import com.example.coroutinesample.R
import kotlinx.coroutines.*

class MainActivity4 : AppCompatActivity(),View.OnClickListener {
    private lateinit var textView: TextView
    private lateinit var rxbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        title = "Aggregated"
        textView = findViewById(R.id.textView7)
        rxbutton=findViewById(R.id.recbutton)
        rxbutton.setOnClickListener(this)

        lifecycleScope.launch(){
            network1()
            delay(3000L)
            network2()

        }
    }
    private suspend fun network2(): Any {
        val sec=withContext(Dispatchers.IO){
            UsersInstance.getinstance().getCommentsData()

        }
        if(sec.isSuccessful){
            Log.d("TAG", "network2: ${sec.body()}")
        }
        return 0

    }

    private suspend fun network1(): Any {
        val ist = withContext(Dispatchers.IO) {
            UsersInstance.getinstance().getUsersData()
        }
        if (ist.isSuccessful) {
            textView.text=ist.body().toString()
            Log.d("TAG", "network1: ${ist.body()}")
        }
        return 0
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.recbutton->{
                val intent=Intent(this@MainActivity4,FinalActivity::class.java)
                startActivity(intent)
            }
        }

    }
}


           // BASIC IDEA
//            lifecycleScope.launch() {
//                val datafetched = withContext(Dispatchers.IO) {
//                    UsersInstance.getinstance().getUsersData()
//
//                }
//
//                if (datafetched.isSuccessful) {
//                    textView.text = datafetched.body().toString()
//                    Log.d("TAG", "onCreate: ${datafetched.body()}")
//                    delay(10000L)
//
//
//                    val commentdata = withContext(Dispatchers.IO) {
//                        UsersInstance.getinstance().getCommentsData()
//                    }
//                    if (commentdata.isSuccessful) {
//                        Log.d("TAG", "onCreate: ${commentdata.body()}")
//                    }
//                }
//            }


