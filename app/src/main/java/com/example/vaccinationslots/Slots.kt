package com.example.vaccinationslots

import adapter.RecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cowinData.CowinData
import cowinData.Session
import interfaceAPI.FetchSlots
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class Slots : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slots)

        val pinText = intent.getStringExtra("pinText")
        val dateText = intent.getStringExtra("dateText")
        val monthText = intent.getStringExtra("monthText")

        lateinit var recyclerViewAdapter : RecyclerViewAdapter

        val listRecyclerView = findViewById<RecyclerView>(R.id.recycleTv)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.layoutManager = LinearLayoutManager(this)

        //val slotText = findViewById<TextView>(R.id.slotTv)
        val baseUrl = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/"

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(FetchSlots::class.java)

        val currDate = dateText.toString() + '-' + monthText.toString() + '-' + "2021"
        val retrofitData = retrofitBuilder.getData(pinText.toString(),currDate)

        retrofitData.enqueue(object : Callback<CowinData?> {
            override fun onResponse(call: Call<CowinData?>, response: Response<CowinData?>) {
                val responseBody = response.body()
                val mySessions = responseBody?.sessions

                recyclerViewAdapter = RecyclerViewAdapter(mySessions)
                listRecyclerView.adapter = recyclerViewAdapter


            }

            override fun onFailure(call: Call<CowinData?>, t: Throwable) {

            }
        })


    }
}