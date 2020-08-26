package com.app.kodeindisample.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.app.kodeindisample.data.model.Quotes

@Database(
    entities = [Quotes::class],
    version = 1
)
abstract class QuotesDatabase :  RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao

    companion object {
        @Volatile private var instance: QuotesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: buildDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            databaseBuilder(context.applicationContext,
                QuotesDatabase::class.java, "Quotes.db")
                .allowMainThreadQueries()
                .build()
    }
}