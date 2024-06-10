package com.example.capstone_2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class choice_doori : AppCompatActivity() {
    var layout_1: LinearLayout? = null
    var layout_2: LinearLayout? = null
    var layout_3: LinearLayout? = null
    var item_cart: TextView? = null
    private var arrayList: ArrayList<MainData>? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice_doori)
        layout_1 = findViewById(R.id.hambak)
        layout_2 = findViewById(R.id.kalgooksu)
        layout_3 = findViewById(R.id.boodae)
        item_cart = findViewById(R.id.item_cart)
        if (arrayList == null) {
            arrayList = ArrayList()
        }
        layout_1?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 돼지고기, 밀, 대두 \n560kccal\n6000원"
            builder.setTitle("함박스테이크").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.hambak, "함박스테이크", "6000원", R.drawable.item_delete_image)
                // 장바구니에 추가하는 부분
                addToCart(mainData)
                Toast.makeText(applicationContext, "장바구니에 담김", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("취소") { dialog, id ->
                Toast.makeText(
                    applicationContext,
                    "취소",
                    Toast.LENGTH_SHORT
                ).show()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        })
        layout_2?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 돼지고기, 밀, 대두 \n600kccal\n4000원"
            builder.setTitle("칼국수").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.kalgooksu, "칼국수", "4000원", R.drawable.item_delete_image)
                // 장바구니에 추가하는 부분
                addToCart(mainData)
                Toast.makeText(applicationContext, "장바구니에 담김", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("취소") { dialog, id ->
                Toast.makeText(
                    applicationContext,
                    "취소",
                    Toast.LENGTH_SHORT
                ).show()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        })
        layout_3?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 닭고기, 밀, 대두 \n560kccal\n5500원"
            builder.setTitle("부대찌개").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.boodae, "부대찌개", "5500원", R.drawable.item_delete_image)
                // 장바구니에 추가하는 부분
                addToCart(mainData)
                Toast.makeText(applicationContext, "장바구니에 담김", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("취소") { dialog, id ->
                Toast.makeText(
                    applicationContext,
                    "취소",
                    Toast.LENGTH_SHORT
                ).show()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        })
        item_cart?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@choice_doori, Item_Cart3::class.java)
            intent.putParcelableArrayListExtra("cartList", arrayList)
            startActivity(intent)
        })
    }

    override fun onResume() {


        // onResume 시, 기존 장바구니 내용을 초기화한 후, Intent로부터 변경된 장바구니 내용을 받아옴
        if (arrayList == null) {
            arrayList = ArrayList()
        }
        val intent = intent
        if (intent != null && intent.hasExtra("cartList_return")) {
            val cartList = intent.getParcelableArrayListExtra<MainData>("cartList_return")
            if (cartList != null) {
                arrayList!!.clear()
                arrayList!!.addAll(cartList)
            }
        }
        super.onResume()
    }

    private fun addToCart(mainData: MainData) {
        if (arrayList == null) {
            arrayList = ArrayList()
        }
        arrayList!!.add(mainData)
    }
}