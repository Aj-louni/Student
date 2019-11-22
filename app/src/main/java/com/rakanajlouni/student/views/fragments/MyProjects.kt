package com.rakanajlouni.student.views.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rakanajlouni.student.R

/**
 * A simple [Fragment] subclass.
 */
class MyProjects : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_my_projects, container, false)

        if (container != null) {
            container.removeAllViews();
        }
        return view
    }


}
