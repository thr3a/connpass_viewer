package com.example.thr3a.compassapisample

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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

        object : MyAsyncTask() {
            override fun doInBackground(vararg p0: Void?): String {
                Log.d("debug", "doInBackground")
                return getHtml()
            }

            override fun onPostExecute(result: String?) {
                Log.d("debug", "onPostExecute")
                val mytext = findViewById<TextView>(R.id.myText)
                mytext.setText(result)
            }
        }.execute()


    }
}

fun getHtml(): String {
    val client = OkHttpClient()
    val req = Request.Builder().url("http://google.com").get().build()
    val resp = client.newCall(req).execute()
    return resp.body()!!.string()
}
