package com.edebtek.covid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Semptomlar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semptomlar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val semptomList = ArrayList<Model>()
        semptomList.add(Model(R.drawable.oksuruk,"Kuru Öksürük","Koronavirüs Hastalığı genel olarak öksürük ile başlar, ilerleyen durumlarda ise solunum güçlüğü ile seyredebilir. "))
        semptomList.add(Model(R.drawable.fever,"Yüksek Ateş","Yüksek Ateş Koronavirüs için en başta gelen semptomlardandır."))
        semptomList.add(Model(R.drawable.pain,"Baş Ağrısı","Soğuk algınlığı ve gribe benzeyen belirtiler ortaya çıkar. Hafif ateş ve boğaz ağrısı görülebilir."))
        semptomList.add(Model(R.drawable.sore_throat,"Boğaz Ağrısı","Virüsten kaynaklı boğaz ağrısı şikâyetleri de olmaktadır. Fakat nadir görülür."))

        val semptomlarAdapter = SemptomlarAdapter(semptomList)

        recyclerView.adapter = semptomlarAdapter
    }
}