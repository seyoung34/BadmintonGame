package com.example.capstone_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Main_Activity : AppCompatActivity() {
    private var orderCountA = 0
    private var orderCountB = 0
    private var orderCountC = 0
    private var textViewA: TextView? = null
    private var textViewB: TextView? = null
    private var textViewC: TextView? = null
    private var btn_pay: Button? = null
    private var btn_reset: Button? = null
    var Left: Button? = null
    private var today_menu_text: TextView? = null
    private var today_manu: ImageView? = null
    private var menu_name: TextView? = null
    var Right: Button? = null
    var today_num = 0
    var today_num1 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        textViewA = findViewById(R.id.textViewA)
        textViewB = findViewById(R.id.textViewB)
        textViewC = findViewById(R.id.textViewC)
        btn_pay = findViewById(R.id.btn_pay)
        btn_reset = findViewById(R.id.btn_reset)
        Left = findViewById(R.id.Left)
        today_menu_text = findViewById(R.id.today_menu_text)
        today_manu = findViewById(R.id.today_menu)
        Right = findViewById(R.id.Right)
        menu_name = findViewById(R.id.menu_name)


        // SharedPreferences 초기화
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        orderCountA = sharedPreferences.getInt("orderCountA", 0)
        orderCountB = sharedPreferences.getInt("orderCountB", 0)
        orderCountC = sharedPreferences.getInt("orderCountC", 0)
        textViewA?.setText("백록관 주문 대기 수: $orderCountA")
        textViewB?.setText("천지관 주문 대기 수: $orderCountB")
        textViewC?.setText("두리관 주문 대기 수: $orderCountC")
        btn_pay?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Main_Activity, choice_cafeteria::class.java)

            // 모든 식당의 주문 수를 인텐트로 전달
            intent.putExtra("orderCountA", orderCountA)
            intent.putExtra("orderCountB", orderCountB)
            intent.putExtra("orderCountC", orderCountC)
            startActivity(intent)
        })
        btn_reset?.setOnClickListener(View.OnClickListener {
            orderCountA = 0
            orderCountB = 0
            orderCountC = 0
            updateOrderCounts()
        })
        Left?.setOnClickListener(View.OnClickListener {
            today_num1 += 2
            updateTodayMenu()
        })
        Right?.setOnClickListener(View.OnClickListener {
            today_num1 += 1
            updateTodayMenu()
        })
    }

    private fun updateOrderCounts() {
        textViewA!!.text = "백록관 주문 대기 수: $orderCountA"
        textViewB!!.text = "천지관 주문 대기 수: $orderCountB"
        textViewC!!.text = "두리관 주문 대기 수: $orderCountC"
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("orderCountA", orderCountA)
        editor.putInt("orderCountB", orderCountB)
        editor.putInt("orderCountC", orderCountC)
        editor.apply()
    }

    fun updateTodayMenu() {
        today_num = today_num1 % 3
        when (today_num) {
            0 -> {
                today_menu_text!!.text = "백록 한라산"
                today_manu!!.setImageResource(R.drawable.kimchi_rice)
                menu_name!!.text = "김치볶음밥"
            }

            1 -> {
                today_menu_text!!.text = "천지 백두산"
                today_manu!!.setImageResource(R.drawable.bulgogi)
                menu_name!!.text = "불고기"
            }

            2 -> {
                today_menu_text!!.text = "크누정식"
                today_manu!!.setImageResource(R.drawable.bibimbap)
                menu_name!!.text = "비빔밥"
            }
        }
    }
}
