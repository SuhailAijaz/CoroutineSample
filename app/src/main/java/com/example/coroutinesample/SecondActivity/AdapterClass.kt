package com.example.coroutinesample.SecondActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesample.R
import com.example.coroutinesample.SecondActivity.network2ndAct.CommentsDataClass
import com.example.coroutinesample.SecondActivity.network2ndAct.CommentsDataClassItem
import org.w3c.dom.Text

class AdapterClass : RecyclerView.Adapter<AdapterClass.InerClass>() {
    class InerClass(idview: View) : RecyclerView.ViewHolder(idview) {
        var postId: TextView
        var id: TextView
        var name: TextView
        var email: TextView
        var body: TextView


        init {
            postId = idview.findViewById(R.id.textView2)
            id = idview.findViewById(R.id.textView3)
            name = idview.findViewById(R.id.textView4)
            email = idview.findViewById(R.id.textView5)
            body = idview.findViewById(R.id.textView6)

        }
    }

    private val commentslist = mutableListOf<CommentsDataClassItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InerClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.targetlayout, parent, false)
        return InerClass(view)
    }

    override fun onBindViewHolder(holder: InerClass, position: Int) {
        holder.postId.text = commentslist[position].postId.toString()
        holder.id.text = commentslist[position].id.toString()
        holder.name.text = commentslist[position].name.toString()
        holder.email.text = commentslist[position].email.toString()
        holder.body.text = commentslist[position].body.toString()

    }

    fun receiveData(nL: List<CommentsDataClassItem>) {
        commentslist.clear()
        commentslist.addAll(nL)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return commentslist.size
    }
}