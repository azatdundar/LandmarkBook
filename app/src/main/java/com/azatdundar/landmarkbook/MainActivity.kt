package com.azatdundar.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.azatdundar.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
        val colosseum = Landmark("Colosseum", "Italy", R.drawable.colosseum)
        val eiffel = Landmark("Eiffel", "France", R.drawable.eiffel)
        val londonBridge = Landmark("London Bridge", "UK", R.drawable.londonbridge)


        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landmarkList)

        binding.recyclerView.adapter = landmarkAdapter

        /* Adapter : Layout & Data
            Bağlamak" derken, adaptörün bir listeyi veya veriyi alıp bunu bir ekran öğesine
            (örneğin, bir liste görünümüne) yerleştirmesi anlamında kullanıyoruz.
            Yani, adaptör veriyi ekranda gösterilecek hale getirir.
         */

        /*

        ViewHolder'ın temel görevleri şunlardır:

        Bir öğeyi temsil eder:
        Her öğe için bir View (görünüm) yapısını tutar.
        Performans sağlar: ViewHolder'lar tekrar kullanılabilir,
        böylece RecyclerView performanslı çalışır.
        Bu, kaydırma sırasında
        eski öğeleri yeniden kullanarak gereksiz View oluşturulmasını önler.



         */






    }
}