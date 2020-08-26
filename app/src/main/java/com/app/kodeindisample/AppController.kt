package com.app.kodeindisample

import com.app.kodeindisample.data.repository.QuoteRepository
import QuoteRepositoryImpl
import android.app.Application
import com.app.kodeindisample.data.db.QuoteDao
import com.app.kodeindisample.data.db.QuotesDatabase
import com.app.kodeindisample.ui.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AppController : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@AppController))

        bind() from singleton {
            QuotesDatabase(
                instance()
            )
        }
        bind<QuoteDao>() with singleton { instance<QuotesDatabase>().getQuoteDao() }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) }
        bind() from provider{
            QuotesViewModelFactory(
                instance()
            )
        }

    }

}