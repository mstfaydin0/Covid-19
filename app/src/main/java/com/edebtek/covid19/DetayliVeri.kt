package com.edebtek.covid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class DetayliVeri : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detayli_veri)


    }

    override fun onStart() {
        super.onStart()

        getGlobalData()

    }



    fun getGlobalData(){
        val url:String ="https://disease.sh/v3/covid-19/countries/turkey"

        val stringRequest = StringRequest(
                Request.Method.GET,
                url,
                {
                    val tests = findViewById<TextView>(R.id.tests)
                    val aktifvaka = findViewById<TextView>(R.id.aktifvaka)
                    val kritikvaka = findViewById<TextView>(R.id.kritikvaka)
                    val bugunvaka = findViewById<TextView>(R.id.bugunvaka)
                    val buguniyilesen = findViewById<TextView>(R.id.buguniyilesen)
                    val bugunolum = findViewById<TextView>(R.id.bugunolum)
                    val pertest = findViewById<TextView>(R.id.pertest)
                    val pervaka = findViewById<TextView>(R.id.pervaka)
                    val perolum = findViewById<TextView>(R.id.perolum)

                    val jsonObject = JSONObject(it.toString())

                    //now set values in textview
                    tests.text = jsonObject.getString("tests")
                    aktifvaka.text = jsonObject.getString("active")
                    kritikvaka.text = jsonObject.getString("critical")
                    bugunvaka.text = jsonObject.getString("todayCases")
                    buguniyilesen.text = jsonObject.getString("todayRecovered")
                    bugunolum.text = jsonObject.getString("todayDeaths")
                    pertest.text = jsonObject.getString("testsPerOneMillion")
                    pervaka.text = jsonObject.getString("casesPerOneMillion")
                    perolum.text = jsonObject.getString("deathsPerOneMillion")

                },
                {
                    Toast.makeText(this@DetayliVeri,it.toString(), Toast.LENGTH_LONG).show()
                    val tests = findViewById<TextView>(R.id.tests)
                    val aktifvaka = findViewById<TextView>(R.id.aktifvaka)
                    val kritikvaka = findViewById<TextView>(R.id.kritikvaka)
                    val bugunvaka = findViewById<TextView>(R.id.bugunvaka)
                    val buguniyilesen = findViewById<TextView>(R.id.buguniyilesen)
                    val bugunolum = findViewById<TextView>(R.id.bugunolum)
                    val pertest = findViewById<TextView>(R.id.pertest)
                    val pervaka = findViewById<TextView>(R.id.pervaka)
                    val perolum = findViewById<TextView>(R.id.perolum)
                    tests.text = "-"
                    aktifvaka.text = "-"
                    kritikvaka.text = "-"
                    bugunvaka.text = "-"
                    buguniyilesen.text = "-"
                    bugunolum.text = "-"
                    pertest.text = "-"
                    pervaka.text = "-"
                    perolum.text = "-"

                }
        )

        val requestQueue = Volley.newRequestQueue(this@DetayliVeri)
        requestQueue.add(stringRequest)

    }
}