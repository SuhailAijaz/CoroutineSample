package com.example.coroutinesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        title="Final checkout of scope"
        lifecycleScope.launch(Dispatchers.Default){

                val first=doNetwork()
                val secone=doNetwork2()
        }
    }

    private suspend fun doNetwork2(): Any {
        val first=withContext(Dispatchers.IO){
            Log.d("TAG", "doNetwork2: Second thread is running")
        }
return 0
    }

    private suspend fun doNetwork(): Any {
        val secone=withContext(Dispatchers.IO) {
            Log.d("TAG", "doNetwork: First thread is running")
        }
return 0
    }

}