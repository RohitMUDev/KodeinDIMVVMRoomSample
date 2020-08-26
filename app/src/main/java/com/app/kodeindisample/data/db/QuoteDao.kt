package com.app.kodeindisample.data.db
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.kodeindisample.data.model.Quotes


@Dao
interface QuoteDao {

    @Insert
    fun addQuote(quote: Quotes)

    @Query("select * from quotes_table ")
    fun getQuotes(): LiveData<List<Quotes>>
}