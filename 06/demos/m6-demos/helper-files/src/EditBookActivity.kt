package com.room.ps.bookkeeper

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new.*

class EditBookActivity : AppCompatActivity() {

	var id: String? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_new)


		bSave.setOnClickListener {
			finish()
		}

		bCancel.setOnClickListener {
			finish()
		}
	}

	companion object {
		const val ID = "book_id"
		const val UPDATED_AUTHOR = "author_name"
		const val UPDATED_BOOK = "book_name"
	}
}