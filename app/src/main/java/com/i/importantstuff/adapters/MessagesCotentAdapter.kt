package com.i.importantstuff.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.i.importantstuff.R
import com.i.importantstuff.activities.MessageDetailsActivity
import com.i.importantstuff.datamodels.MessageContent
import kotlinx.android.synthetic.main.messages_layout_rv.view.*

class MessagesCotentAdapter(var messageArrayList: ArrayList<MessageContent>):
    RecyclerView.Adapter<MessagesCotentAdapter.MessageViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) :MessageViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.messages_layout_rv, parent, false)

        view.setOnClickListener(){
            val intent= Intent(parent.context,MessageDetailsActivity::class.java)
            parent.context.startActivity(intent)
        }

        return MessageViewHolder(view)
    }

    override fun getItemCount(): Int {
       return messageArrayList.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        holder.bind(messageArrayList[position])


    }

    class MessageViewHolder(view: View):RecyclerView.ViewHolder(view) {

        private val messageTitle:TextView = view.message_title_tv
        private val dotImage: ImageView = view.dot
        private val message:TextView =view.message_tv
        private val date : TextView =view.date_tv
        private val messagetType: TextView =view.message_type

        fun bind(messageContent: MessageContent){
            messageTitle.text=messageContent.messageTitle
            message.text=messageContent.message
            date.text=messageContent.date
            messagetType.text=messageContent.messageType

        }

    }
}