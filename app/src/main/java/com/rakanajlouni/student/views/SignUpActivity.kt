package com.rakanajlouni.student.views

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.rakanajlouni.student.Constants.AppInfo
import com.rakanajlouni.student.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        sign_up_button.setOnClickListener {

            var pd = ProgressDialog(this)
            pd.setMessage(getString(R.string.PleaseWait))
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.show()

            if (!isEmailValid(sign_up_email.text.toString())) {
                pd.hide()
                Toast.makeText(
                    this,
                    "Email is not valid or empty, please try again",
                    Toast.LENGTH_LONG
                ).show()
            } else if (sign_up_first_name.text.toString() == "") {
                pd.hide()
                Toast.makeText(this, "First name is empty, please try again", Toast.LENGTH_LONG)
                    .show()
            } else if (sign_up_last_name.text.toString() == "") {
                pd.hide()
                Toast.makeText(this, "Second name is empty, please try again", Toast.LENGTH_LONG)
                    .show()
            } else if (sign_up_password.text.toString() == "" || sign_up_password_confirmation.text.toString() == "") {
                pd.hide()
                Toast.makeText(this, "Password is empty, please try again", Toast.LENGTH_LONG)
                    .show()
            } else if (sign_up_password.text.toString() != sign_up_password_confirmation.text.toString()) {
                pd.hide()
                Toast.makeText(this, "Password does not match, please try again", Toast.LENGTH_LONG)
                    .show()

                // This Request Queue talks to the Web API to insert the data using POST method
            } else {
                var rq = Volley.newRequestQueue(this)
                var sr = object : StringRequest(Request.Method.POST, AppInfo.web + "signup.php",
                    Response.Listener { response ->
                        pd.hide()

                        if (response == "1") {
                            AppInfo.email = sign_up_email.text.toString()
                            var i = Intent(this, HomeActivity::class.java)
                            startActivity(i)
                            finish()
                        }
                        else Toast.makeText(this,"Email already exists",Toast.LENGTH_LONG).show()
                    },
                    Response.ErrorListener { error ->
                        pd.hide()
                        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                    })
                {
                    override fun getParams(): MutableMap<String, String> {
                        var map = HashMap<String, String>()
                        map.put("first_name", sign_up_first_name.text.toString())
                        map.put("last_name", sign_up_last_name.text.toString())
                        map.put("email", sign_up_email.text.toString())
                        map.put("password", sign_up_password.text.toString())

                        return map
                    }
                }

                rq.add(sr)
            }
        }
    }

        fun isEmailValid(email: String): Boolean {
            val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(email)
            return matcher.matches()
        }
}
