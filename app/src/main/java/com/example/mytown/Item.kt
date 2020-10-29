package com.example.mytown

class Item(line: String)
{
	var city: String
	var lat: Float
	var lng: Float
	var timeZone: String
	var imageResource: Int
	
	init
	{
		val components = line.split(",")
		city = components[0]
		lat = components[1].toFloat()
		lng = components[2].toFloat()
		timeZone = components[3]

		imageResource = if (timeZone.contains("Melbourne"))
							R.drawable.heart
						else
							R.drawable.empty
	}
}