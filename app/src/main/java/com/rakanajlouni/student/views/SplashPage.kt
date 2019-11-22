package com.rakanajlouni.student.views

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.rakanajlouni.student.R
import kotlinx.android.synthetic.main.activity_main.*

class SplashPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_page)

        getSupportActionBar()!!.hide()

        var obj = object : Thread() {

            override fun run() {
                super.run()
                sleep(3000)
                var sp = getSharedPreferences("user_data", Context.MODE_PRIVATE)
                var email = sp.getString("accemail",null)
                if(email!=null){
                    startActivity(Intent(applicationContext, HostActivity::class.java))
                    finish()
                }else{
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }
            }

        }
        obj.start()

    }
}