package com.example.saturnus_narum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saturnus_narum.databinding.ActivityMainBinding
import com.example.saturnus_narum.databinding.ActivityThirdBinding
import com.example.saturnus_narum.pertemuan3.ThirdResultActivity
import com.example.saturnus_narum.pertemuan4.FourthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnToFourth: Button = findViewById(R.id.btnToFourth)

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Pesan Berhasil Dikirim", Toast.LENGTH_SHORT)
                .show()
        }
    }
}