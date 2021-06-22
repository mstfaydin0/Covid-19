package com.edebtek.covid19

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DahaFazlasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daha_fazlasi)

        val btnDahaFazla = findViewById<Button>(R.id.btnLearnMore)

        btnDahaFazla.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://covid19.saglik.gov.tr/"))
            startActivity(intent)
        }
    }
}