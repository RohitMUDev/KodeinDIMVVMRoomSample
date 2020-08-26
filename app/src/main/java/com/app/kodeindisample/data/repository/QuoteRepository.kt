package com.app.kodeindisample.data.repository
import androidx.lifecycle.LiveData
import com.app.kodeindisample.data.model.Quotes


interface QuoteRepository {
    fun addQuote(quote: Quotes)
    fun getQuotes(): LiveData<List<Quotes>>
}