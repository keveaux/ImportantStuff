package com.i.importantstuff.activities

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.i.importantstuff.R
import com.i.importantstuff.adapters.MessagesCotentAdapter
import com.i.importantstuff.adapters.SpinnerAdapter
import com.i.importantstuff.datamodels.MessageContent
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, SignUpActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val listofMessageCategory = arrayOf("All Messages","Meetings","Appointment","Unread","Read")

        var spinnerAdapter : SpinnerAdapter = SpinnerAdapter(applicationContext,listofMessageCategory)
        var spinner:Spinner = findViewById(R.id.spinnerTariffCalculator)
        spinner?.adapter=spinnerAdapter


        val dates = arrayOf("Today","This week","This Month","This Year")

        var datespinnerAdapter : SpinnerAdapter = SpinnerAdapter(applicationContext,dates)
        var datespinner:Spinner = findViewById(R.id.spinner_date)
        datespinner?.adapter=datespinnerAdapter


        add_keyword_btn.setOnClickListener{AddKeywordPopUp()
        }

        val messageContentArrayList:ArrayList<MessageContent> = ArrayList()

        messageContentArrayList.add(MessageContent("Meeting","This is a custom message","2:30pm","EMAIL"))
        messageContentArrayList.add(MessageContent("Appointment","This is a custom message","2:30pm","TEXT"))
        messageContentArrayList.add(MessageContent("Water Bill","This is a custom message","2:30pm","EMAIL"))
        messageContentArrayList.add(MessageContent("Meeting","This is a custom message","2:30pm","TEXT"))
        messageContentArrayList.add(MessageContent("Appointment","This is a custom message","2:30pm","EMAIL"))
        messageContentArrayList.add(MessageContent("Cancellation","This is a custom message","2:30pm","TEXT"))
        messageContentArrayList.add(MessageContent("Meeting","This is a custom message","2:30pm","EMAIL"))

        val messages_rv:RecyclerView = findViewById(R.id.messages_rv)
        val messagesCotentAdapter:MessagesCotentAdapter=MessagesCotentAdapter(messageContentArrayList)

        messages_rv.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=messagesCotentAdapter

        }

    }

    private fun AddKeywordPopUp() {
        val dialogBuilder =
            AlertDialog.Builder(this@MainActivity)
        val layoutView: View = this@MainActivity.getLayoutInflater()
            .inflate(R.layout.add_message_tag, null)
        dialogBuilder.setView(layoutView)
        dialogBuilder.setCancelable(true)




        val alertDialog = dialogBuilder.create()
        alertDialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        alertDialog.show()
    }

}
