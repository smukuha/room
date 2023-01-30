package com.room.ps.bookkeeper

import android.app.Activity
import android.app.SearchManager
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class SearchResultActivity : AppCompatActivity(), BookListAdapter.OnDeleteClickListener {

	private lateinit var searchViewModel: SearchViewModel
	private var bookListAdapter: BookListAdapter? = null
	private val TAG = this.javaClass.simpleName

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val toolbar = findViewById<Toolbar>(R.id.toolbar)
		setSupportActionBar(toolbar)

		fab.visibility = View.INVISIBLE

		searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

		bookListAdapter = BookListAdapter(this, this)
		recyclerview.adapter = bookListAdapter
		recyclerview.layoutManager = LinearLayoutManager(this)

	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)

		if (requestCode == SearchResultActivity.UPDATE_NOTE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
			// Code to edit book
			val bookId = data!!.getStringExtra(EditBookActivity.ID)
			val authorName = data.getStringExtra(EditBookActivity.UPDATED_AUTHOR)
			val bookName = data.getStringExtra(EditBookActivity.UPDATED_BOOK)

			val book = Book(bookId, authorName, bookName)
			searchViewModel.update(book)

			Toast.makeText(applicationContext, R.string.updated, Toast.LENGTH_LONG).show()

		}
		else {
			Toast.makeText(applicationContext, R.string.not_saved, Toast.LENGTH_LONG).show()
		}
	}

	override fun onDeleteClickListener(myBook: Book) {
		searchViewModel.delete(myBook)
		Toast.makeText(applicationContext, R.string.deleted, Toast.LENGTH_LONG).show()
	}

	companion object {
		const val UPDATE_NOTE_ACTIVITY_REQUEST_CODE = 2
	}
}
