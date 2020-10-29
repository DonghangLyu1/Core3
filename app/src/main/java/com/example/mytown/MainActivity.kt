package com.example.mytown

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity()
{
	private lateinit var view: View
	private lateinit var items: ArrayList<Item>
	private lateinit var recyclerView: RecyclerView
	
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		view = findViewById(R.id.layout)
		items = ArrayList()
		recyclerView = findViewById(R.id.recyclerView)
		
		initData()
		initRecyclerView()
	}
	
	private fun initData()
	{
		items.clear()
		
		val inputStream = resources.openRawResource(R.raw.au_locations)
		val inputStreamReader = InputStreamReader(inputStream, "UTF-8")
		val bufferReader = BufferedReader(inputStreamReader)
		
		do
		{
			val line = bufferReader.readLine()
			
			if (line != null)
			{
				items.add(Item(line))
			}
			else
				break
		}
		while (true)
	}
	
	private fun initRecyclerView()
	{
		val layoutManager = LinearLayoutManager(this)
		recyclerView.layoutManager = layoutManager
		layoutManager.orientation = RecyclerView.VERTICAL
		recyclerView.adapter = ItemAdapter(items)
		recyclerView.itemAnimator = DefaultItemAnimator()
	}
}