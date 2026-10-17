package com.example.saturnus_narum

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saturnus_narum.databinding.ActivityMainBinding
import com.example.saturnus_narum.Home.pertemuan5.FifthActivity
import com.example.saturnus_narum.Home.pertemuan7.SeventhActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//      val btnToFourth: Button = findViewById(R.id.btnToFourth)
        binding.btnToFourth.setOnClickListener {
            val i = Intent(this, FifthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(i)
            Toast.makeText(this, "Pesan Berhasil Dikirim", Toast.LENGTH_SHORT)
                .show()
        }

        binding.btnToFifth.setOnClickListener {
            val i = Intent(this, FifthActivity::class.java)
            startActivity(i)
        }

        binding.btnToSeventh.setOnClickListener {
            val i = Intent(this, SeventhActivity::class.java)
            startActivity(i)
        }

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        // Tampilkan username yang disimpan saat login
        val username = sharedPref.getString("username", "")
        binding.textHalo.text = "Halo, $username"

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Apakah anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // Hapus data login
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}