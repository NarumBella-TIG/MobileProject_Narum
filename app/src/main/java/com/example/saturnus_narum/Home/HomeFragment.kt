package com.example.saturnus_narum.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.saturnus_narum.Home.pertemuan5.FifthActivity
import com.example.saturnus_narum.Home.pertemuan7.SeventhActivity
import com.example.saturnus_narum.R
import com.example.saturnus_narum.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        binding.btnToFourth.setOnClickListener {
            val i = Intent(requireContext(), FifthActivity::class.java)
            i.putExtra("name", "Politeknik Caltex Riau")
            i.putExtra("from", "Rumbai")
            i.putExtra("age", 25)
            startActivity(i)
            Toast.makeText(requireContext(), "Pesan Berhasil Dikirim", Toast.LENGTH_SHORT)
                .show()
        }

        binding.btnToFifth.setOnClickListener {
            val i = Intent(requireContext(), FifthActivity::class.java)
            startActivity(i)
        }

        binding.btnToSeventh.setOnClickListener {
            val i = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(i)
        }

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        // Tampilkan username yang disimpan saat login
        val username = sharedPref.getString("username", "")
        binding.textHalo.text = "Halo, $username"

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // Hapus data login
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}