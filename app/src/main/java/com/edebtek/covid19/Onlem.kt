package com.edebtek.covid19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Onlem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onlem)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Ellerini Yıka","El hijyeninde amaç; kimyasal ve fiziksel zararlıların ve enfeksiyonlara yol açan mikroorganizmaların uzaklaştırılmasını sağlamaktır."))
        precautionsList.add(Model(R.drawable.hone,"Evde Kal","Evde kalmak enfeksiyon zincirini kırmak için en önemli halk sağlığı önlemlerden biridir."))
        precautionsList.add(Model(R.drawable.distance,"Sosyal Mesafe","Enfekte olmaktan kaçınmak için 1.5 mt. sosyal mesafeye dikkat etmeliyiz."))
        precautionsList.add(Model(R.drawable.clean,"Yüzeyleri Temizle","Yüzeyleri temizlemek dezenfektanla silmeye çalışmak virüs açısından çok önemlidir."))
        precautionsList.add(Model(R.drawable.cover,"Temastan Kaçının","Özellikle halka açık yüzeylere dokunmaktan kaçınmak."))

        val precautionsAdapter = OnlemAdapter(precautionsList)

        recyclerView.adapter = precautionsAdapter

    }
}