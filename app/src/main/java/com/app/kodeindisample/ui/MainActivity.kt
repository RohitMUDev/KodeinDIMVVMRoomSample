package com.app.kodeindisample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.app.kodeindisample.R
import com.app.kodeindisample.data.model.Quotes
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()
    private val viewModelFactory: QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =  ViewModelProviders.of(this, viewModelFactory)
            .get(QuoteViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer {

            val stringBuilder = StringBuilder()
            it.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })


        button_add_quote.setOnClickListener {
            val quote = Quotes(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuotes(quote)

        }
    }
}