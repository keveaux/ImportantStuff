package com.i.importantstuff

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class EmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        someTask(applicationContext).execute()


    }

    class someTask(val context: Context) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            // ...
            // for POP3
            val protocol = "pop3";
            val host = "pop.gmail.com";
            val port = "995";

            // for IMAP
//        val protocol = "imap"
//        val host = "imap.gmail.com"
//        val port = "993"


            val userName = "kevmirera@gmail.com"
            val password = "awesome96!"

            val receiver = EmailReceiver(context)
            receiver.downloadEmails(protocol, host, port, userName, password)
            return null
        }

        override fun onPreExecute() {
            super.onPreExecute()
            // ...
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            // ...
        }
    }
}
