package com.edebtek.covid19

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this) {}

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-9455123396521751/3611836553"

        mInterstitialAd.loadAd(AdRequest.Builder().build())

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val recyclerViewOnlem = findViewById<RecyclerView>(R.id.recyclerViewPrecautions)
        val dahaFazlasi = findViewById<Button>(R.id.btnKnowMore)
        val txtViewSemptomlar = findViewById<TextView>(R.id.txtViewSymptoms)
        val txtViewOnlemler = findViewById<TextView>(R.id.txtViewOnlemler)
        val detayligoster = findViewById<LinearLayout>(R.id.detay)
        val kayanyazi = findViewById<TextView>(R.id.kayanyazi)

        kayanyazi.isSelected = true



        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val SemptomList = ArrayList<Model>()
        SemptomList.add(Model(R.drawable.oksuruk, "Kuru Öksürük", "Koronavirüs Hastalığı genel olarak öksürük ile başlar, ilerleyen durumlarda ise solunum güçlüğü ile seyredebilir."))
        SemptomList.add(Model(R.drawable.fever, "Yüksek Ateş", "Yüksek Ateş Koronavirüs için en başta gelen semptomlardandır."))
        SemptomList.add(Model(R.drawable.pain, "Baş Ağrısı", "Soğuk algınlığı ve gribe benzeyen belirtiler ortaya çıkar. Hafif ateş ve boğaz ağrısı görülebilir."))

        val semptomlarAdapter = SemptomlarAdapter(SemptomList)

        recyclerView.adapter = semptomlarAdapter


        recyclerViewOnlem.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val Onlemlist = ArrayList<Model>()
        Onlemlist.add(Model(R.drawable.soap, "Ellerini Yıka", "El hijyeninde amaç; kimyasal ve fiziksel zararlıların ve enfeksiyonlara yol açan mikroorganizmaların uzaklaştırılmasını sağlamaktır."))
        Onlemlist.add(Model(R.drawable.hone, "Evde Kal", "Evde kalmak enfeksiyon zincirini kırmak için en önemli halk sağlığı önlemlerden biridir."))
        Onlemlist.add(Model(R.drawable.distance, "Sosyal Mesafe", "Enfekte olmaktan kaçınmak için 1.5 mt. sosyal mesafeye dikkat etmeliyiz."))

        val onlemAdapter = SemptomlarAdapter(Onlemlist)

        recyclerViewOnlem.adapter = onlemAdapter

        detayligoster.setOnClickListener {
            var intent = Intent(this@MainActivity, DetayliVeri::class.java)
            startActivity(intent)
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            }
        }

        txtViewSemptomlar.setOnClickListener {
            var intent = Intent(this@MainActivity, Semptomlar::class.java)
            startActivity(intent)
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            }
        }

        dahaFazlasi.setOnClickListener {
            var intent = Intent(this@MainActivity, DahaFazlasi::class.java)
            startActivity(intent)
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            }
        }

        txtViewOnlemler.setOnClickListener {
            var intent = Intent(this@MainActivity, Onlem::class.java)
            startActivity(intent)
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            }
        }



    }

    override fun onResume() {
        super.onResume()

        getGlobalData()

    }

    fun getGlobalData(){
        val url:String ="https://disease.sh/v3/covid-19/countries/turkey"

        val stringRequest = StringRequest(
                Request.Method.GET,
                url,
                Response.Listener<String> {
                    val txtInfected = findViewById<TextView>(R.id.txtInfected)
                    val txtRecoverd = findViewById<TextView>(R.id.txtRecoverd)
                    val txtDeceased = findViewById<TextView>(R.id.txtDeceased)

                    var jsonObject = JSONObject(it.toString())

                    //now set values in textview
                    txtInfected.text = jsonObject.getString("cases")
                    txtRecoverd.text = jsonObject.getString("recovered")
                    txtDeceased.text = jsonObject.getString("deaths")

                },
                Response.ErrorListener {
                    Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_LONG).show()
                    val txtInfected = findViewById<TextView>(R.id.txtInfected)
                    val txtRecoverd = findViewById<TextView>(R.id.txtRecoverd)
                    val txtDeceased = findViewById<TextView>(R.id.txtDeceased)
                    txtInfected.text = "-"
                    txtRecoverd.text = "-"
                    txtDeceased.text = "-"

                }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)

    }
}