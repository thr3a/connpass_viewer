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

open class MyAsyncTask : AsyncTask<Void, Void, String>() {
    override fun doInBackground(vararg p0: Void?): String? {
        return null
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }
}

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter : CustomAdapter
    private var list = arrayListOf<CustomItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = CustomAdapter(this, list)
        MyAsyncTask().execute()
    }

    inner class MyAsyncTask: AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String {
            return getHtml()
        }

        override fun onPostExecute(result: String?) {
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val adapter = moshi.adapter(Events::class.java)

            val res = adapter.fromJson(result)

            if (res != null) {

                res.events.forEach{ event ->
                    val a = CustomItem(event.title)
                    list.add(a)
                }
                var lv = findViewById(R.id.eventList) as ListView
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


