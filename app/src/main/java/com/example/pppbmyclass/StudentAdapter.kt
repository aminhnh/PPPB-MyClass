package com.example.pppbmyclass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pppbmyclass.databinding.ItemStudentBinding

typealias OnClickStudent = (Student) -> Unit
class StudentAdapter(private val listStudent : List<Student>, private val onClickStudent : OnClickStudent)
    : RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

    inner class ItemStudentViewHolder(private val binding : ItemStudentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : Student){
            with(binding){
                val context = itemView.context

                txtName.text = data.name
                txtNim.text = data.nim
                txtIpkNilai.text = data.ipk.toString()
                imgProfile.setImageResource(data.image)

                val drawableIpkCompat = DrawableCompat.wrap( txtIpkNilai.background )
                val drawableProfileCompat = DrawableCompat.wrap( imgProfileBg.background )

                val colorBlue = ContextCompat.getColor(context,  R.color.blue)
                val colorGreen = ContextCompat.getColor(context,  R.color.green)
                val colorYellow = ContextCompat.getColor(context,  R.color.yellow)
                val colorRed = ContextCompat.getColor(context,  R.color.red)

                if (data.ipk >= 3.5){
                    DrawableCompat.setTint(drawableIpkCompat, colorBlue)
                    DrawableCompat.setTint(drawableProfileCompat, colorBlue)
                } else if (data.ipk >= 3){
                    DrawableCompat.setTint(drawableIpkCompat, colorGreen)
                    DrawableCompat.setTint(drawableProfileCompat, colorGreen)
                } else if (data.ipk >= 2){
                    DrawableCompat.setTint(drawableIpkCompat, colorYellow)
                    DrawableCompat.setTint(drawableProfileCompat, colorYellow)
                } else {
                    DrawableCompat.setTint(drawableIpkCompat, colorRed)
                    DrawableCompat.setTint(drawableProfileCompat, colorRed)
                }

                itemView.setOnClickListener {
                    onClickStudent(data)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(listStudent[position])
    }
}