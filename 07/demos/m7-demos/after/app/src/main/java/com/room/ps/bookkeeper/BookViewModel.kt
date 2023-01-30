package com.room.ps.bookkeeper

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class BookViewModel(application: Application): AndroidViewModel(application) {

	val allBooks: LiveData<List<Book>>
	private val bookRepository = BookRepository(application)

	init {
		allBooks = bookRepository.allBooks
	}

	fun insert(book: Book) {
		bookRepository.insert(book)
	}

	fun update(book: Book) {
		bookRepository.update(book)
	}

	fun delete(book: Book) {
		bookRepository.delete(book)
	}
}