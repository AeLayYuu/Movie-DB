package com.wya.movieapp.ui.popular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wya.movieapp.R
import com.wya.movieapp.ui.model.ResultX
import kotlinx.android.synthetic.main.item_popular.view.*

class PopularAdapter(var resultList: List<ResultX> = ArrayList<ResultX>()):RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    class PopularViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindPopular(resultX: ResultX){
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+resultX.poster_path).into(itemView.imageViewPopular)
            itemView.txtTitlePopular.text=resultX.title
        }

    }
    fun updateResultPopular(resultList: List<ResultX>){
        this.resultList=resultList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_popular,parent, false)
        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bindPopular(resultList[position])
    }
}