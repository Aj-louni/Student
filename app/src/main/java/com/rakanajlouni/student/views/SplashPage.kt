package com.rakanajlouni.student.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.rakanajlouni.student.R

class SplashPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_page)

        getSupportActionBar()!!.hide()

        var obj = object : Thread() {

            override fun run() {
                super.run()
                sleep(3000)
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }

        }
        obj.start()

    }
}