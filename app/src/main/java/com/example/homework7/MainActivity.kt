package com.example.homework7

import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.homework7.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addField()
    }

    private fun addField() {

        binding.btnAddField.setOnClickListener {
            val fieldName = binding.edEnterFieldName.text.toString()
            val isNumeric = binding.cbNumeric.isChecked

            if (fieldName.isEmpty()) {
                Toast.makeText(this, "Enter the field name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newEd = EditText(this)
            newEd.hint = fieldName
            newEd.setBackgroundResource(R.drawable.ed_bg)

            val density = resources.displayMetrics.density
            val paddingHorizontal = (17 * density).toInt()
            val paddingVertical = (10 * density).toInt()
            newEd.setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical)

            val marginTop = (10 * density).toInt()

            val layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, marginTop, 0, 0)
            newEd.layoutParams = layoutParams

            newEd.inputType = if (isNumeric) {
                InputType.TYPE_CLASS_NUMBER
            }else {
                InputType.TYPE_CLASS_TEXT
            }
            binding.mainLayout.addView(newEd)
        }

    }

}