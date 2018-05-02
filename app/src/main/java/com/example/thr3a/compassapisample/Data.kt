package com.example.thr3a.compassapisample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*

data class Events(
        val results_returned: Int,
        val events: List<Event>,
        val results_start: Int,
        val results_available: Int
)

@Parcelize
data class Event (
        val event_url: String,
        val event_type: String,
        val owner_nickname: String,
        val series: Series,
        val updated_at: String,
        val lat: String,
        var started_at: String,
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
): Parcelable {
    fun date2():String {
        val df1 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        val df2 = SimpleDateFormat("MM/dd")
        val dt = df1.parse(this.started_at)
        return df2.format(dt)
    }
}

@Parcelize
data class Series(
        val url: String,
        val id: Int,
        val title: String
): Parcelable
