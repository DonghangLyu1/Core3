package com.example.mytown

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var items: List<Item>) : RecyclerView.Adapter<ItemHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder
    {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int)
    {
        holder.setAs(items[position])
    }

    override fun getItemCount(): Int
    {
        return items.size
    }
}