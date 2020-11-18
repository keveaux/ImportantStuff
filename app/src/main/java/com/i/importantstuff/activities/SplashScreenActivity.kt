package com.i.importantstuff.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.i.importantstuff.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)

        openActivitiesMethod()
    }

    private fun openActivitiesMethod() {

        val intent=Intent(this,WelcomeScreenActivity::class.java)
        startActivity(intent)
    }


}
