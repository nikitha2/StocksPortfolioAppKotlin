package com.example.stocksportfolioappkotlin.stocksPortfolio.ui

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stocksportfolioappkotlin.Fragmentbase
import com.example.stocksportfolioappkotlin.databinding.FragmentStocksPortfolioFullListBinding
import com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels.Stock
import com.example.stocksportfolioappkotlin.stocksPortfolio.viewmodel.PortfolioViewModel
import io.reactivex.internal.disposables.DisposableHelper.replace


class StocksPortfolioEmptyListFragment : Fragmentbase() {
    private lateinit var binding: FragmentStocksPortfolioFullListBinding
    private val portfolioViewModel: PortfolioViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStocksPortfolioFullListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        portfolioViewModel.getPortfolioStocksEmptyList()
        setUpObservers()
    }

    private fun setUpObservers() {
        portfolioViewModel.getPortfolioStocksEmptyList().observe(viewLifecycleOwner){
            it?.data?.let { stocks->
                setupViews(stocks)
            }?: kotlin.run {
                showNoStocksText(binding.noStocks,binding.stocksFullListRV)
            }
        }
    }

    private fun setupViews(list:List<Stock>?) {
        setupList(list,binding.noStocks,binding.stocksFullListRV)
    }

    companion object {
        fun newInstance(): StocksPortfolioEmptyListFragment = StocksPortfolioEmptyListFragment()
    }
}