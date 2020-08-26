
import com.app.kodeindisample.data.db.QuoteDao
import com.app.kodeindisample.data.repository.QuoteRepository
import com.app.kodeindisample.data.model.Quotes


class QuoteRepositoryImpl(private val quoteDao: QuoteDao)
    : QuoteRepository {
    override fun addQuote(quote: Quotes) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()
}