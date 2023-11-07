package com.example.pppbmyclass

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.pppbmyclass.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        title = "View Student Profile"

        with(binding){
            val ipk = intent.getDoubleExtra("ipk", 0.0)

            txtName.text = intent.getStringExtra("name")
            txtNim.text = intent.getStringExtra("nim")
            txtIpkNilai.text = ipk.toString()
            imgProfile.setImageResource(intent.getIntExtra("image", R.drawable.baseline_person_pin_24))
            txtKota.text = intent.getStringExtra("kotaAsal")
            txtMatkul.text = intent.getStringExtra("matkulFav")

            val drawableTop = DrawableCompat.wrap( imgTopColor.background )

            val colorBlue = ContextCompat.getColor(this@ProfileActivity,  R.color.blue)
            val colorGreen = ContextCompat.getColor(this@ProfileActivity,  R.color.green)
            val colorYellow = ContextCompat.getColor(this@ProfileActivity,  R.color.yellow)
            val colorRed = ContextCompat.getColor(this@ProfileActivity,  R.color.red)

            if (ipk >= 3.5){
                DrawableCompat.setTint(drawableTop, colorBlue)
                btnBack.strokeColor = ContextCompat.getColorStateList(this@ProfileActivity, R.color.blue)
                //supportActionBar?.setBackgroundDrawable(ColorDrawable(colorBlue))
            } else if (ipk >= 3){
                DrawableCompat.setTint(drawableTop, colorGreen)
                btnBack.strokeColor = ContextCompat.getColorStateList(this@ProfileActivity, R.color.green)
                //supportActionBar?.setBackgroundDrawable(ColorDrawable(colorGreen))
            } else if (ipk >= 2){
                DrawableCompat.setTint(drawableTop, colorYellow)
                btnBack.strokeColor = ContextCompat.getColorStateList(this@ProfileActivity, R.color.yellow)
                //supportActionBar?.setBackgroundDrawable(ColorDrawable(colorYellow))
            } else {
                DrawableCompat.setTint(drawableTop, colorRed)
                btnBack.strokeColor = ContextCompat.getColorStateList(this@ProfileActivity, R.color.red)
                //supportActionBar?.setBackgroundDrawable(ColorDrawable(colorRed))
            }

            DrawableCompat.setTint(DrawableCompat.wrap(imgProfileBg.background), ContextCompat.getColor(this@ProfileActivity, R.color.bg_grey))
            //supportActionBar?.hide()


            btnBack.setOnClickListener{
                finish()
            }
        }
    }
}