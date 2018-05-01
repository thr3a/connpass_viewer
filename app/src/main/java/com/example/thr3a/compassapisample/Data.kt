package com.example.thr3a.compassapisample

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
