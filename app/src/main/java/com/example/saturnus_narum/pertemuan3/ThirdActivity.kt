package com.example.saturnus_narum.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saturnus_narum.R
import com.example.saturnus_narum.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputNoTujuan: EditText = findViewById(R. id.inputNoTujuan)
        val btnKirim: Button = findViewById(R.id.btnKirim)

        binding.btnKirim.setOnClickListener {
        //Mengambil value dari inputNama dan menampilkan di Logcat
            val nomor = inputNoTujuan.text

            Log.e("Klik btnSubmit", "Tombol berhasil di tekan. Isi dari inputNama")

            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Pesan Berhasil Dikirim $nomor", Toast.LENGTH_SHORT)
                .show()
        }
    }
}