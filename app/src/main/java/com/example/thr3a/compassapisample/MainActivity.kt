package com.example.thr3a.compassapisample

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.Request
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter : CustomAdapter
    private var eventList = ArrayList<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = CustomAdapter(this, eventList)
        MyAsyncTask().execute()
    }

    inner class MyAsyncTask: AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg p0: Void?): String {
            return getHtml()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val adapter = moshi.adapter(Events::class.java)

            val res = adapter.fromJson(result)

            if (res != null) {

                res.events.forEach{ event ->
//                    val df1 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
//                    val df2 = SimpleDateFormat("MM/dd")
//                    val dt = df1.parse(event.started_at)

//                    val item = CustomItem("11111", df2.format(dt))

                    eventList.add(event)
                }
                var lv = findViewById<ListView>(R.id.eventList)
                lv.adapter = myAdapter
            }
        }
    }



}

fun getHtml(): String {
    val client = OkHttpClient()
    val url = "https://connpass.com/api/v1/event/?keyword=kotlin"
    val req = Request.Builder().url(url).get().build()
    val resp = client.newCall(req).execute()
    return resp.body()!!.string()
}


