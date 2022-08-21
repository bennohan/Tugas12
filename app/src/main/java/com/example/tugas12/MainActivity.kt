package com.example.tugas12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.tugas12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val inputNama = MutableLiveData("")

    private var akanDisimpan: String? = ""

    private lateinit var dataku:Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataku= Database(this)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.activity = this

        inputNama.observe(this) {
            akanDisimpan = it
        }
        binding.nama = dataku.getName()
    }

    fun saveName(){
        dataku.saveName(akanDisimpan)
        binding.nama = akanDisimpan
    }

}