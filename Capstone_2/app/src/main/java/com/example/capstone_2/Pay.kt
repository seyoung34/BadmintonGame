package com.example.capstone_2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Pay : AppCompatActivity() {
    private var btn_pay: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pay)
        btn_pay = findViewById(R.id.btn_pay)
        btn_pay?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Pay, Main_Activity::class.java)
            startActivity(intent)
        })
    }
}