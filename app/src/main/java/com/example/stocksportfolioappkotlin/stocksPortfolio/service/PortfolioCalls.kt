package com.example.stocksportfolioappkotlin.stocksPortfolio.service

import com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels.PortfolioResponseModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PortfolioCalls {

    @GET("/cash-homework/cash-stocks-api/portfolio.json")
    fun getPortfolioStocksFullList(): Call<PortfolioResponseModel>

    @GET("/cash-homework/cash-stocks-api/portfolio_malformed.json")
    fun getPortfolioStocksMalformedList(): Call<PortfolioResponseModel>

    @GET("/cash-homework/cash-stocks-api/portfolio_empty.json")
    fun getPortfolioStocksEmptyList(): Call<PortfolioResponseModel>



    companion object {

        var BASE_URL = "https://storage.googleapis.com/"
        fun create() : PortfolioCalls {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(PortfolioCalls::class.java)

        }
    }
}