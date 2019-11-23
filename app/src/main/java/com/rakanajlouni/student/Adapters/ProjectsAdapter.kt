package com.rakanajlouni.student.Adapters

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.rakanajlouni.student.Models.projects
import com.rakanajlouni.student.R
import kotlinx.android.synthetic.main.recycle_item.view.*

class ProjectsAdapter: BaseAdapter {

    var foodsList = ArrayList<projects>()
    var context: Context? = null

    constructor(context: FragmentActivity?, foodsList: ArrayList<projects>) : super() {
        this.context = context
        this.foodsList = foodsList
    }

    override fun getCount(): Int {
        return foodsList.size
    }

    override fun getItem(position: Int): Any {
        return foodsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = this.foodsList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var foodView = inflator.inflate(R.layout.recycle_item, null)
        foodView.imgFood.setImageResource(food.image!!)
        foodView.tvName.text = food.name!!

        return foodView
    }
}