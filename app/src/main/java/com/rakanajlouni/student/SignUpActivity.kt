package com.rakanajlouni.student

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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

            var rq=Volley.newRequestQueue(this)
            var sr=object:StringRequest(Request.Method.POST,AppInfo.web+"signup.php",
                    Response.Listener { response ->
                        pd.hide()
                        AppInfo.email = sign_up_email.text.toString()
                        var i=Intent(this,HomeActivity::class.java)
                        startActivity(i)
                        finish()
                    } ,
                    Response.ErrorListener {error->
                        pd.hide()
                        Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
                    })

                    rq.add(sr)
        }
    }
}
