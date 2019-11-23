package com.rakanajlouni.student.views.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.rakanajlouni.student.Adapters.ProjectsAdapter
import com.rakanajlouni.student.Models.projects

import com.rakanajlouni.student.R
import kotlinx.android.synthetic.main.fragment_search_projects.*

/**
 * A simple [Fragment] subclass.
 */
class SearchProjects : Fragment() {

    var adapter: ProjectsAdapter? = null
    var foodsList = ArrayList<projects>()
    lateinit var gv:GridView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_search_projects, container, false)
        if (container != null) {
            container.removeAllViews();
        }
        gv = view.findViewById(R.id.gv)
        foodsList.add(projects("Coffee", R.drawable.ic_menu_camera))
        foodsList.add(projects("Espersso", R.drawable.ic_menu_gallery))
        foodsList.add(projects("French Fires", R.drawable.ic_menu_manage))
        foodsList.add(projects("Honey",R.drawable.ic_menu_send))
        foodsList.add(projects("Strawberry", R.drawable.ic_menu_share))
        foodsList.add(projects("Sugar cubes", R.drawable.ic_menu_slideshow))
        foodsList.add(projects("French Fires", R.drawable.ic_menu_manage))
        foodsList.add(projects("Honey",R.drawable.ic_menu_send))
        foodsList.add(projects("Strawberry", R.drawable.ic_menu_share))
        foodsList.add(projects("Sugar cubes", R.drawable.ic_menu_slideshow))
        adapter = ProjectsAdapter(activity, foodsList)

        gv.adapter = adapter
        return view
    }


}
