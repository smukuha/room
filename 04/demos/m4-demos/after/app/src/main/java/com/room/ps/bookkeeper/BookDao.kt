package com.room.ps.bookkeeper

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert

@Dao
interface BookDao {

	@Insert
	fun insert(book: Book)
}