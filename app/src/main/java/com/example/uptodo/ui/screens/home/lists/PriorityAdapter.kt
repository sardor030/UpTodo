package com.example.uptodo.ui.screens.home.lists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uptodo.R

class PriorityAdapter() : RecyclerView.Adapter<PriorityAdapter.ViewHolder>() {

    var list = ArrayList<String>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onClick: (() -> Unit)? = null
    var selectedItem: Int = 0

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvLevel: TextView? = null
        private var llPriority: LinearLayout? = null

        init {
            tvLevel = itemView.findViewById(R.id.tv_level)
            llPriority = itemView.findViewById(R.id.ll_priority)
        }

        @SuppressLint("NotifyDataSetChanged")
        fun onBind(data: String, position: Int) {
            tvLevel?.text = data

            if (selectedItem == position) {
                llPriority?.setBackgroundResource(R.drawable.rounded_primiry_color_card_r4)
            } else {
                llPriority?.setBackgroundResource(R.drawable.rounded_light_black_card_r4)
            }

            itemView.setOnClickListener {
                if (selectedItem != position) {
                    selectedItem = position
                    notifyItemChanged(selectedItem)
                    notifyDataSetChanged()
                }
            }
        }

    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_priority, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }
}