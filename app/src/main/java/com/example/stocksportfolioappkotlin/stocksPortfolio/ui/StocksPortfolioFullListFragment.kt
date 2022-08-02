package com.example.stocksportfolioappkotlin.stocksPortfolio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.stocksportfolioappkotlin.FragmentBase
import com.example.stocksportfolioappkotlin.databinding.FragmentStocksPortfolioFullListBinding
import com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels.Stock
import com.example.stocksportfolioappkotlin.stocksPortfolio.viewmodel.PortfolioViewModel


class StocksPortfolioFullListFragment : FragmentBase() {
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
        portfolioViewModel.getPortfolioStocksFullList()
        setUpObservers()
    }

    private fun setUpObservers() {
        portfolioViewModel.getPortfolioStocksFullList().observe(viewLifecycleOwner){
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
        fun newInstance(): StocksPortfolioFullListFragment = StocksPortfolioFullListFragment()
    }
}