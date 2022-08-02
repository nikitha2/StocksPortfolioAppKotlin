package com.example.stocksportfolioappkotlin.stocksPortfolio.service

import android.app.AlertDialog
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels.PortfolioResponseModel
import com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels.Stock
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface PortfolioRepoInterface {
    fun getPortfolioStocksFullList(): MutableLiveData<PortfolioResponseModel?>
    fun getPortfolioStocksMalformedList(): MutableLiveData<PortfolioResponseModel?>
    fun getPortfolioStocksEmptyList(): MutableLiveData<PortfolioResponseModel?>
}

class PortfolioRepoService: PortfolioRepoInterface {
    val TAG: String = this::class.java.simpleName
    private val portfolioCalls = PortfolioCalls.create()

    var portfolioListResourceHolder: MutableLiveData<PortfolioResponseModel?> = MutableLiveData()
    var portfolioMalformedListResourceHolder: MutableLiveData<PortfolioResponseModel?> = MutableLiveData()
    var portfolioEmptyListResourceHolder: MutableLiveData<PortfolioResponseModel?> = MutableLiveData()

    override fun getPortfolioStocksFullList(): MutableLiveData<PortfolioResponseModel?> {
        portfolioCalls.getPortfolioStocksFullList()
            .enqueue(object : Callback<PortfolioResponseModel> {
                override fun onResponse(
                    call: Call<PortfolioResponseModel>,
                    response: Response<PortfolioResponseModel>
                ) {
                    portfolioListResourceHolder.value = response.body()
                    Log.d(TAG, response.body().toString())
                }

                override fun onFailure(call: Call<PortfolioResponseModel>, t: Throwable) {
                    portfolioMalformedListResourceHolder.value = null
                }
            })
        return portfolioListResourceHolder
    }

    override fun getPortfolioStocksMalformedList(): MutableLiveData<PortfolioResponseModel?> {
        portfolioCalls.getPortfolioStocksMalformedList().enqueue(object : Callback<PortfolioResponseModel> {
            override fun onResponse(call: Call<PortfolioResponseModel>, response: Response<PortfolioResponseModel>) {
                portfolioMalformedListResourceHolder.value= response.body()
                Log.d(TAG,response.body().toString())
            }

            override fun onFailure(call: Call<PortfolioResponseModel>, t: Throwable) {
                portfolioMalformedListResourceHolder.value=null
            }
        })
        return portfolioMalformedListResourceHolder
    }

    override fun getPortfolioStocksEmptyList(): MutableLiveData<PortfolioResponseModel?> {
        portfolioCalls.getPortfolioStocksEmptyList().enqueue(object : Callback<PortfolioResponseModel> {
            override fun onResponse(call: Call<PortfolioResponseModel>, response: Response<PortfolioResponseModel>) {
                portfolioEmptyListResourceHolder.value= response.body()
                Log.d(TAG,response.body().toString())
            }

            override fun onFailure(call: Call<PortfolioResponseModel>, t: Throwable) {
                portfolioMalformedListResourceHolder.value=null
            }
        })
        return portfolioEmptyListResourceHolder
    }
}