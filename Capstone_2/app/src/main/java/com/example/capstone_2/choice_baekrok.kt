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

class choice_baekrok : AppCompatActivity() {
    var layout_1: LinearLayout? = null
    var layout_2: LinearLayout? = null
    var layout_3: LinearLayout? = null
    var layout_4: LinearLayout? = null
    var layout_5: LinearLayout? = null
    var layout_6: LinearLayout? = null
    var layout_7: LinearLayout? = null
    var layout_8: LinearLayout? = null
    var item_cart: TextView? = null
    var ok: TextView? = null
    private var arrayList: ArrayList<MainData>? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice_baekrok)
        layout_1 = findViewById(R.id.deungsim)
        layout_2 = findViewById(R.id.gochidon)
        layout_3 = findViewById(R.id.chicken)
        layout_4 = findViewById(R.id.lamen_1)
        layout_5 = findViewById(R.id.lamen_2)
        layout_6 = findViewById(R.id.lamen_3)
        layout_7 = findViewById(R.id.gookbap_1)
        layout_8 = findViewById(R.id.gookbap_2)
        item_cart = findViewById(R.id.item_cart)
        //ok = findViewById(R.id.ok)
        if (arrayList == null) {
            arrayList = ArrayList()
        }
        layout_1?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 돼지고기, 밀, 대두 \n560kccal\n4800원"
            builder.setTitle("등심돈까스").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.deungsim, "등심돈까스", "4800원", R.drawable.item_delete_image)
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
            val string_deungsim = "ex)알레르기 정보 : 돼지고기, 밀, 대두 \n600kccal\n5000원"
            builder.setTitle("고치돈").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.gochidon, "고치돈", "5000원", R.drawable.item_delete_image)
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
            val string_deungsim = "ex)알레르기 정보 : 닭고기, 밀, 대두 \n560kccal\n4900원"
            builder.setTitle("치킨까스").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.chicken, "치킨까스", "4900원", R.drawable.item_delete_image)
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
        layout_4?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 밀, 대두 \n560kccal\n3000원"
            builder.setTitle("라면").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.lamen_1, "라면", "3000원", R.drawable.item_delete_image)
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
        layout_5?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 밀, 대두 \n560kccal\n3500원"
            builder.setTitle("떡만두라면").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.lamen_2, "떡만두라면", "3500원", R.drawable.item_delete_image)
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
        layout_6?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 밀, 대두 \n560kccal\n3300원"
            builder.setTitle("해장라면").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.lamen_3, "해장라면", "3300원", R.drawable.item_delete_image)
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
        layout_7?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 돼지고기, 밀, 대두 \n560kccal\n5800원"
            builder.setTitle("수육국밥").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.gookbap_1, "수육국밥", "5800원", R.drawable.item_delete_image)
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
        layout_8?.setOnClickListener(View.OnClickListener { v ->
            val builder = AlertDialog.Builder(v.context)
            val string_deungsim = "ex)알레르기 정보 : 돼지고기, 밀, 대두 \n560kccal\n6300원"
            builder.setTitle("얼큰국밥").setMessage(string_deungsim)
            builder.setPositiveButton("장바구니 담기") { dialog, id ->
                val mainData =
                    MainData(R.drawable.gookbap_2, "얼큰국밥", "6300원", R.drawable.item_delete_image)
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
            val intent = Intent(this@choice_baekrok, Item_Cart::class.java)
            intent.putParcelableArrayListExtra("cartList", arrayList)
            startActivity(intent)
        })
//        ok?.setOnClickListener(View.OnClickListener { v ->
//            val builder = AlertDialog.Builder(v.context)
//            val string_ok = arrayList.toString()
//            builder.setTitle("현재 arrayList").setMessage(string_ok)
//            builder.setPositiveButton("ok") { dialog, id ->
//                Toast.makeText(
//                    applicationContext,
//                    "ok",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            builder.setNegativeButton("취소") { dialog, id ->
//                Toast.makeText(
//                    applicationContext,
//                    "취소",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            val alertDialog = builder.create()
//            alertDialog.show()
//        })
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