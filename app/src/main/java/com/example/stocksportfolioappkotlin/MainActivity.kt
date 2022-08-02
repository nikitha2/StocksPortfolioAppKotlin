package com.example.stocksportfolioappkotlin

import android.os.Bundle
import com.example.stocksportfolioappkotlin.Constants.Companion.STOCKS_EMPTY_LIST
import com.example.stocksportfolioappkotlin.Constants.Companion.STOCKS_FULL_LIST
import com.example.stocksportfolioappkotlin.Constants.Companion.STOCKS_MALFORMED_LIST
import com.example.stocksportfolioappkotlin.databinding.ActivityMainBinding

class MainActivity : BaseActivity()  {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        context=this
        setupViews()
    }

    private fun setupViews() {
        binding.stocksFullListButton.setOnClickListener {
            openActivity(STOCKS_FULL_LIST)
        }

        binding.stocksMalformedListButton.setOnClickListener {
            openActivity(STOCKS_MALFORMED_LIST)
        }

        binding.stocksEmptyListButton.setOnClickListener {
            openActivity(STOCKS_EMPTY_LIST)
        }
    }
}