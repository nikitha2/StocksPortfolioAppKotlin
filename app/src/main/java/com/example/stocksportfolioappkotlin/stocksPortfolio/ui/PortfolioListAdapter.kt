package com.example.stocksportfolioappkotlin.stocksPortfolio.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.stocksportfolioappkotlin.R
import com.example.stocksportfolioappkotlin.stocksPortfolio.model.responseModels.Stock
import java.text.DecimalFormat


class PortfolioListAdapter(private val stocks: List<Stock?>?): RecyclerView.Adapter<PortfolioListAdapter.PortfolioViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
            return PortfolioViewHolder(v)
        }

        override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
            val f = DecimalFormat("##.00")

            holder.ticker.text = stocks?.get(position)?.ticker
            holder.name.text = stocks?.get(position)?.name
            holder.currency.text = stocks?.get(position)?.currency
            holder.current_price_cents.text = "${
                (stocks?.get(position)?.current_price_cents?.toFloat())?.div(506.34235225795123)
                    ?.let { f.format(it).toString() }
            }"
            holder.quantity.text = "Stocks owned: ${stocks?.get(position)?.quantity?.let { it.toString()}?: kotlin.run { "0" }}"
            holder.current_price_timestamp.text ="TIme: ${stocks?.get(position)?.current_price_timestamp.toString()}"
            holder.stockCard.setOnClickListener {
                if(holder.group.isVisible) {
                    holder.group.visibility=View.GONE
                }else{
                    holder.group.visibility=View.VISIBLE
                }
            }
        }

        override fun getItemCount(): Int {
            return stocks?.let { return it.size }?: kotlin.run { return 0 }
        }

        class PortfolioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var ticker: TextView = itemView.findViewById(R.id.ticker)
            var name: TextView = itemView.findViewById(R.id.name)
            var currency: TextView = itemView.findViewById(R.id.currency)
            var current_price_cents: TextView = itemView.findViewById(R.id.current_price_cents)
            var quantity: TextView = itemView.findViewById(R.id.quantity)
            var current_price_timestamp: TextView = itemView.findViewById(R.id.current_price_timestamp)
            var stockCard:CardView =itemView.findViewById(R.id.stockCard)
            var group: Group =itemView.findViewById(R.id.group)
        }
}