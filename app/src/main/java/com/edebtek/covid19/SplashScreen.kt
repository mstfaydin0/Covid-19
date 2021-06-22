package com.edebtek.covid19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

class SplashScreen : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this) {}

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-9455123396521751/3611836553"

        mInterstitialAd.loadAd(AdRequest.Builder().build())

        setContentView(R.layout.activity_splash_screen)

        val btnGo = findViewById<ImageButton>(R.id.btnGo)

        btnGo.setOnClickListener {
            var intent = Intent(this@SplashScreen,MainActivity::class.java)
            startActivity(intent)
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            }
        }
    }
}