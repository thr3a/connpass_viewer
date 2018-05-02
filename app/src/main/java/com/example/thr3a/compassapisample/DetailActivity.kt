package com.example.thr3a.compassapisample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val event = intent.extras.getParcelable<Event>("event")
        findViewById<TextView>(R.id.title).text = event.title
        findViewById<TextView>(R.id.started_at).text = event.started_at.toString()
        findViewById<TextView>(R.id.description).text = event.description

    }
}