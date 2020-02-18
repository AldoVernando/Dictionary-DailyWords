package com.example.dictionary_dailywords.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.dictionary_dailywords.R
import com.example.dictionary_dailywords.models.quote.Quote
import com.example.dictionary_dailywords.models.dictionary.ResultResponse
import com.example.dictionary_dailywords.viewmodels.QuoteViewModel
import com.example.dictionary_dailywords.viewmodels.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var wordViewModel : WordViewModel
    private lateinit var quoteViewModel: QuoteViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        wordViewModel = WordViewModel()
        quoteViewModel = QuoteViewModel()

        val wordObserver = Observer<ResultResponse> { newData ->
            word_definition.text = newData.results[0].lexicalEntries[0].entries[0].senses[0].definitions[0]
        }

        wordViewModel.data.observe(this, wordObserver)

        val quoteObserver = Observer<Quote> { newData ->
            quote_text.text = "'" +  newData.quoteText + "'" + " - " + newData.quoteAuthor
        }

        quoteViewModel.data.observe(this, quoteObserver)

        word_text.text = wordViewModel.word_data

    }
}
