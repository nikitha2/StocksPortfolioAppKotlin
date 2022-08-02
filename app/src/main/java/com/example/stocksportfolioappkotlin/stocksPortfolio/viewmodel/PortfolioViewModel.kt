package com.example.stocksportfolioappkotlin.stocksPortfolio.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels.PortfolioResponseModel
import com.example.stocksportfolioappkotlin.stocksPortfolio.service.PortfolioRepoService

class PortfolioViewModel : ViewModel() {
    private val portfolioService: PortfolioRepoService = PortfolioRepoService()

    fun getPortfolioStocksFullList(): MutableLiveData<PortfolioResponseModel?> {
        return portfolioService.getPortfolioStocksFullList()
    }

    fun getPortfolioStocksMalformedList(): LiveData<PortfolioResponseModel?> {
        return portfolioService.getPortfolioStocksMalformedList()
    }

    fun getPortfolioStocksEmptyList(): MutableLiveData<PortfolioResponseModel?> {
        return portfolioService.getPortfolioStocksEmptyList()
    }
}