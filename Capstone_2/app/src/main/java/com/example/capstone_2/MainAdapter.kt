package com.example.capstone_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone_2.MainAdapter.CustomViewHolder

class MainAdapter(private val arrayList: ArrayList<MainData>?) :
    RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.iv_profile.setImageResource(arrayList!![position].iv_profile)
        holder.tv_name.text = arrayList[position].tv_name
        holder.tv_content.text = arrayList[position].tv_content
        holder.item_delete.setImageResource(arrayList[position].item_delete) //추가됨
        holder.itemView.tag = position
        holder.itemView.setOnClickListener { v ->
            val curName = holder.tv_name.getText().toString()
            Toast.makeText(v.context, curName, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnLongClickListener {
            remove(holder.layoutPosition)
            true
        }
        holder.item_delete.setOnClickListener { remove(holder.layoutPosition) }
    }

    override fun getItemCount(): Int {
        return arrayList?.size ?: 0
    }

    fun remove(position: Int) {
        try {
            arrayList!!.removeAt(position)
            notifyItemRemoved(position)
        } catch (ex: IndexOutOfBoundsException) {
            ex.printStackTrace()
        }
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView
        var tv_name: TextView
        var tv_content: TextView
        var item_delete //추가됨
                : ImageView

        init {
            iv_profile = itemView.findViewById<View>(R.id.iv_profile) as ImageView
            tv_name = itemView.findViewById<View>(R.id.tv_name) as TextView
            tv_content = itemView.findViewById<View>(R.id.tv_content) as TextView
            item_delete = itemView.findViewById<View>(R.id.item_delete) as ImageView //추가됨
        }
    }
}
