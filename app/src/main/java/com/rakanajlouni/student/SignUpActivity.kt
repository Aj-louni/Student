package com.rakanajlouni.student

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_button.setOnClickListener{

            var pd=ProgressDialog(this)
            pd.setMessage("Please Wait...")
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.show()

        }
    }
}
