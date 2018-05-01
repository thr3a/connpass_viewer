package com.example.thr3a.compassapisample

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.view.LayoutInflater

class CustomAdapter(var context: Context, var eventList: ArrayList<Event>) : BaseAdapter() {

    val inflater: LayoutInflater

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val vh: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.event_list, parent, false)
            vh = ViewHolder(view)
            view.tag = vh
            Log.i("JSA", "set Tag for ViewHolder, position: " + position)
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

        vh.date.text = eventList[position].date2()
        vh.title.text = eventList[position].title

        return view
    }

    override fun getItem(position: Int): Any {
        return eventList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return eventList.size
    }
}

private class ViewHolder(view: View) {
    val date: TextView
    val title: TextView

    init {
        this.date = view.findViewById<TextView>(R.id.date)
        this.title = view.findViewById<TextView>(R.id.title)
    }

    //  if you target API 26, you should change to:
//        init {
//            this.tvTitle = view?.findViewById<TextView>(R.id.tvTitle) as TextView
//            this.tvContent = view?.findViewById<TextView>(R.id.tvContent) as TextView
//        }
}
