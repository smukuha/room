package com.room.ps.bookkeeper

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

class BookListAdapter(private val context: Context) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
		val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
		return BookViewHolder(itemView)
	}

	override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
	}

	override fun getItemCount(): Int = 0
	
	inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
	}
}
