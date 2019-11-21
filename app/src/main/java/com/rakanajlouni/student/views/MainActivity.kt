package com.rakanajlouni.student.views

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.rakanajlouni.student.Constants.AppInfo
import com.rakanajlouni.student.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sign_in_btn.setOnClickListener {
            var pd = ProgressDialog(this)
            pd.setMessage(getString(R.string.PleaseWait))
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.show()
            if (!sign_in_email.text.equals("") && sign_in_password.text.toString() != "") {
                if (!isEmailValid(sign_in_email.text.toString())) {
                    pd.hide()
                    Toast.makeText(
                        this,
                        getString(R.string.Email_or_password_is_incorrect),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    var rq = Volley.newRequestQueue(this)
                    var sr = object : StringRequest(
                        Request.Method.POST, AppInfo.web + "login.php",
                        Response.Listener { response ->
                            pd.hide()

                            if (response == "1") {

                                //This is to save the account information so when you close the app and open it again it wont ask for your information again like username and password
                                //when the user check the remember me check box in the activity_main.xml
                                if (radio.isChecked) {
                                    var sp = getSharedPreferences("user_data", Context.MODE_PRIVATE)
                                    var editor = sp.edit()
                                    editor.putString("accemail", sign_in_email.text.toString())
                                    editor.commit()
                                }
                                // AppInfo.number saves the user information in a companion object in the AppInfo class
                                AppInfo.email = sign_in_email.text.toString()

                                // The Intent line takes you to the HomeActivity when you press the sign in button
                                var i = Intent(this, HomeActivity::class.java)
                                startActivity(i)
                                finish()
                            } else
                                Toast.makeText(
                                    this,
                                    getString(R.string.Email_or_password_is_incorrect),
                                    Toast.LENGTH_SHORT
                                ).show()
                        },
                        Response.ErrorListener { error ->
                            pd.hide()
                            Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                        })
                    {
                        override fun getParams(): MutableMap<String, String> {
                            var map = HashMap<String,String>()
                            map.put("email",sign_in_email.text.toString())
                            map.put("password",sign_in_password.text.toString())
                            return map
                        }
                    }
                    rq.add(sr)
                }
            }
        }
        sign_up_btn.setOnClickListener{
            startActivity(Intent(applicationContext, SignUpActivity::class.java))
            finish()
        }

    }

    fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}