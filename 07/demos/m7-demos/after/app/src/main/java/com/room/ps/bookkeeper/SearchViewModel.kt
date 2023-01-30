package com.room.ps.bookkeeper

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class SearchViewModel(application: Application) : AndroidViewModel(application) {

	private val bookRepository = BookRepository(application)

	fun getBooksByBookOrAuthor(searchQuery: String): LiveData<List<Book>>? {
		return bookRepository.getBooksByBookOrAuthor(searchQuery)
	}

	fun update(book: Book) {
		bookRepository.update(book)
	}

	fun delete(book: Book) {
		bookRepository.delete(book)
	}
}
