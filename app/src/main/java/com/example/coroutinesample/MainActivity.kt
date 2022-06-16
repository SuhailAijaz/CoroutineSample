package com.example.coroutinesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesample.SecondActivity.MainActivity2
import com.example.coroutinesample.network.RetroInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var nxt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="APi Data w/o RecyclerView"
        textView=findViewById(R.id.textView)
        nxt=findViewById(R.id.nxtbutton)
        button=findViewById(R.id.button)
        button.setOnClickListener(this)
        nxt.setOnClickListener(this)
        lifecycleScope.launch(Dispatchers.Main) {
            val result=withContext(Dispatchers.IO) {
               RetroInstance.getService().getData()
            }
            if (result.isSuccessful) {
                textView.text=result.body().toString()
                Log.d("TAG", "onCreate: ${result.body().toString()}")
            }
        }}

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.button->{
                val intent= Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
            }R.id.nxtbutton->{
                val intent=Intent(this@MainActivity, MainActivity4::class.java)
            startActivity(intent)
            }

        }
    }


}


