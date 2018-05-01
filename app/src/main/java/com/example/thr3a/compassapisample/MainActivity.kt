package com.example.thr3a.compassapisample

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                val eventCount = res.results_returned.toString()
                val mytext = findViewById<TextView>(R.id.myText)
                mytext.setText(eventCount)
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

data class Events(
    val results_returned: Int,
    val events: List<Event>,
    val results_start: Int,
    val results_available: Int
)

data class Event(
    val event_url: String,
    val event_type: String,
    val owner_nickname: String,
    val series: Series,
    val updated_at: String,
    val lat: String,
    val started_at: String,
    val hash_tag: String,
    val title: String,
    val event_id: Int,
    val lon: String,
    val waiting: Int,
    val limit: Int,
    val owner_id: Int,
    val owner_display_name: String,
    val description: String,
    val address: String,
    val catch: String,
    val accepted: Int,
    val ended_at: String,
    val place: String
)

data class Series(
    val url: String,
    val id: Int,
    val title: String
)
