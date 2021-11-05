package com.example.vaccinationslots

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // view ids
        val pinText = findViewById<EditText>(R.id.pinText)
        val dateText = findViewById<EditText>(R.id.dateText)
        val monthText = findViewById<EditText>(R.id.monthText)
        val createBtn = findViewById<Button>(R.id.createButton)

        createBtn.setOnClickListener {
            if(pinText.text.isEmpty() || dateText.text.isEmpty() || monthText.text.isEmpty()){
                Toast.makeText(this,"Valid Entry please",Toast.LENGTH_SHORT).show()
            }

            else{
                val intent = Intent(this,Slots::class.java)
                intent.putExtra("pinText",pinText.text.toString())
                intent.putExtra("dateText",dateText.text.toString())
                intent.putExtra("monthText",monthText.text.toString())
                startActivity(intent)
            }
        }

    }
}