package com.example.stocksportfolioappkotlin

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels.Stock
import com.example.stocksportfolioappkotlin.stocksPortfolio.ui.PortfolioListAdapter

open class FragmentBase: Fragment() {

    fun setupList(list:List<Stock>?, noStocks:TextView,stocksFullListRV: RecyclerView ) {
        list?.let {
            if(list.isNotEmpty()) {
                noStocks.visibility = View.GONE
                stocksFullListRV.visibility = View.VISIBLE
                val adapter = PortfolioListAdapter(list)
                val verticalLayoutManager =
                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                stocksFullListRV.adapter = adapter
                stocksFullListRV.layoutManager = verticalLayoutManager
            }else{
                showNoStocksText(noStocks,stocksFullListRV)
            }
        }?: run{
            showNoStocksText(noStocks,stocksFullListRV)
        }
    }

    fun showNoStocksText(noStocks:TextView,stocksFullListRV: RecyclerView,text:String?=null) {
        noStocks.visibility=View.VISIBLE
        stocksFullListRV.visibility=View.GONE
        text?.let {
            noStocks.text=text
        }
    }
}