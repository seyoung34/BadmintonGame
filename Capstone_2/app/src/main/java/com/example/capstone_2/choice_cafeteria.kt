package com.example.capstone_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class choice_cafeteria : AppCompatActivity() {
    private var btn_1: Button? = null
    private var btn_2: Button? = null
    private var btn_3: Button? = null
    var result_1 = 0
    var result_2 = 0
    var result_3 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice_cafeteria)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)

        // SharedPreferences 초기화
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // 다른 식당의 주문 수 가져오기
        result_1 = sharedPreferences.getInt("orderCountA", 0)
        result_2 = sharedPreferences.getInt("orderCountB", 0)
        result_3 = sharedPreferences.getInt("orderCountC", 0)

        btn_1?.let { button ->
            button.setOnClickListener {
                val intent = Intent(this@choice_cafeteria, choice_baekrok::class.java)
                startActivity(intent)
            }
        }

        btn_2?.let { button ->
            button.setOnClickListener {
                val intent = Intent(this@choice_cafeteria, choice_chenge::class.java)
                startActivity(intent)
            }
        }

        btn_3?.let { button ->
            button.setOnClickListener {
                val intent = Intent(this@choice_cafeteria, choice_chenge::class.java)
                startActivity(intent)
            }
        }



    }
}
