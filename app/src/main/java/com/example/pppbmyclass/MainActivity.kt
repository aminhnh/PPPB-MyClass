package com.example.pppbmyclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pppbmyclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        title = "Students of Class Neko~Neko"
        val adapterStudent = StudentAdapter(generateStudent()){
            student ->
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)

            intent.putExtra("name", student.name)
            intent.putExtra("nim", student.nim)
            intent.putExtra("ipk", student.ipk)
            intent.putExtra("image", student.image)
            intent.putExtra("kotaAsal", student.kotaAsal)
            intent.putExtra("matkulFav", student.matkulFav)

            startActivity(intent)
        }
        with(binding){
            rvStudents.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

    }

    private fun generateStudent() : List<Student>{
        return listOf(
            Student(name = "Taichi Mashima", nim = "23/393866/PA/20039", ipk = 4.0, image = R.drawable.pfp1, kotaAsal = "Jepara", matkulFav = "Kapita Selekta"),
            Student(name = "Sumire Hanano", nim = "21/393866/SV/20039", ipk = 3.7, image = R.drawable.pfp2, kotaAsal = "Malang", matkulFav = "Bahasa Arab"),
            Student(name = "Yusei Nishida", nim = "21/393866/FI/20039", ipk = 3.4, image = R.drawable.pfp3, kotaAsal = "Bandung", matkulFav = "Pemrograman Berorientasi Objek"),
            Student(name = "Arata Wataya", nim = "21/393866/SV/20039", ipk = 3.1, image = R.drawable.pfp4, kotaAsal = "Jakarta", matkulFav = "Praktikum Pemrograman Web 2"),
            Student(name = "Kanade Oe", nim = "20/393866/FT/20039", ipk = 2.8, image = R.drawable.pfp5, kotaAsal = "Sigli", matkulFav = "Praktikum Basis Data"),
            Student(name = "Tsutomu Komanu", nim = "20/393866/FT/20039", ipk = 2.5, image = R.drawable.pfp6, kotaAsal = "Binjai", matkulFav = "Rekayasa Kebutuhan Perangkat Lunak"),
            Student(name = "Chihaya Ayase", nim = "22/393866/KT/20039", ipk = 2.2, image = R.drawable.pfp7, kotaAsal = "Surakarta", matkulFav = "Matematika Diskrit"),
            Student(name = "Shinobu Wakamiya", nim = "22/393866/FK/20039", ipk = 1.9, image = R.drawable.pfp8, kotaAsal = "Jayapura", matkulFav = "Praktikum Pemrograman Komputer"),
            Student(name = "Akihito Sudo", nim = "22/393866/FK/20039", ipk = 1.3, image = R.drawable.pfp9, kotaAsal = "Denpasar", matkulFav = "Statistika"),
        )
    }


}