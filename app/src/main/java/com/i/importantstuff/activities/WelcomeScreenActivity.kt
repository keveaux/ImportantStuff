package com.i.importantstuff.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.i.importantstuff.R
import kotlinx.android.synthetic.main.activity_welcome_screen.*

class WelcomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        button_open_main_activity.setOnClickListener(){
            openActivitiesMethod()
        }

        button_sign_in.setOnClickListener(){
            openActivitiesMethod()
        }

    }

    private fun openActivitiesMethod() {

        val intent= Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }
}
