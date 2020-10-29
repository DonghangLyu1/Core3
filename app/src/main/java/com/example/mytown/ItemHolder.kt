package com.example.mytown

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener
{
	private var cityTV: TextView = itemView.findViewById(R.id.city)
	private var timeZoneTV: TextView = itemView.findViewById(R.id.timezone)
	private var mButton: AppCompatButton = itemView.findViewById(R.id.image)
	private lateinit var location: String

	fun setAs(item: Item)
	{
		cityTV.text = item.city
		timeZoneTV.text = item.timeZone
		mButton.setBackgroundResource(item.imageResource)

		location = String.format("%f, %f", item.lat, item.lng)

		itemView.setOnClickListener(this)
	}

	override fun onClick(v: View?)
	{
		if (v != null)
		{
			Snackbar.make(v, location, Snackbar.LENGTH_LONG).show()
		}
	}
}
