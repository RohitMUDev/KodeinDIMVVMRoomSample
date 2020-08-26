package com.app.kodeindisample.ui

import com.app.kodeindisample.data.repository.QuoteRepository
import androidx.lifecycle.ViewModel
import com.app.kodeindisample.data.model.Quotes

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

        fun addQuotes(quotes: Quotes){

            quoteRepository.addQuote(quotes)
        }

       fun getQuotes() = quoteRepository.getQuotes()


}