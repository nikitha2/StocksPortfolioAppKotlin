package com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PortfolioResponseModel(
    @SerializedName("stocks") val data: List<Stock>
): Serializable

class Stock (
    var ticker: String,
    var name: String,
    var currency: String,
    var current_price_cents: Int,
    var quantity: Int?,
    var current_price_timestamp: Int
): Serializable


