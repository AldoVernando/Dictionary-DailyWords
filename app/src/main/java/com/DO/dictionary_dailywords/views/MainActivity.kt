package com.DO.dictionary_dailywords.views

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.dictionary_dailywords.R
import com.DO.dictionary_dailywords.models.dictionary.ResultResponse
import com.DO.dictionary_dailywords.models.quote.Quote
import com.DO.dictionary_dailywords.viewmodels.QuoteViewModel
import com.DO.dictionary_dailywords.viewmodels.WordViewModel
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

        search_btn.setOnClickListener {
            val query = search_text.text.toString()
            val keyboard = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.hideSoftInputFromWindow(it.windowToken, 0)

            if(!query.isEmpty()) {
                word_definition.text = ""
                word_text.text = query
                wordViewModel.getData(query)
            }
        }
    }
}
