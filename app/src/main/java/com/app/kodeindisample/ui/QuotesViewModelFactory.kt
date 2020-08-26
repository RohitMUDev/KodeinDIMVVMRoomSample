package com.app.kodeindisample.ui
import com.app.kodeindisample.data.repository.QuoteRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepository) as T
    }
}