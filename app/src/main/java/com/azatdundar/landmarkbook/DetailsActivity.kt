package com.azatdundar.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azatdundar.landmarkbook.databinding.ActivityDetailsBinding
import com.azatdundar.landmarkbook.databinding.ActivityMainBinding
import android.os.Build

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root

        val intent = intent // it refers to intent that came here

        val selectedLandmark = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("landmark", Landmark::class.java)
        }
        else{
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("landmark") as? Landmark
        }

        selectedLandmark?.let {
            binding.countryText.text = selectedLandmark.country
            binding.nameText.text = selectedLandmark.name
            binding.imageView.setImageResource(selectedLandmark.image)
        }




        setContentView(view)


    }
}

