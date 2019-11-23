package com.rakanajlouni.student.views.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.rakanajlouni.student.R

/**
 * A simple [Fragment] subclass.
 */
class UploadProjects : Fragment() {

    val types = arrayOf("IT", "Art")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            var view= inflater.inflate(R.layout.fragment_upload_projects, container, false)
            val spinner = view.findViewById<Spinner>(R.id.spinner)
            spinner?.adapter = ArrayAdapter(activity?.applicationContext, R.layout.support_simple_spinner_dropdown_item, types)
            spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    println("Error")
                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val type = parent?.getItemAtPosition(position).toString()
                    Toast.makeText(activity,type, Toast.LENGTH_LONG).show()
                    println(type)
                }

            }

        // Inflate the layout for this fragment
        if (container != null) {
            container.removeAllViews();
        }
        return view

    }


}
