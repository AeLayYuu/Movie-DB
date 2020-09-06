package com.wya.movieapp.ui.Play

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wya.movieapp.R
import com.wya.movieapp.ui.model.ResultXX
import kotlinx.android.synthetic.main.item_play.view.*
import kotlinx.android.synthetic.main.item_rated.view.*

class PlayAdapter(var resultList: List<ResultXX> = ArrayList<ResultXX>()) :
    RecyclerView.Adapter<PlayAdapter.PlayViewHolder>() {
    class PlayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindPlay(result: ResultXX) {
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + result.poster_path)
                .into(itemView.imageViewPlay)
            itemView.txtTitlePlay.text=result.title
        }
    }

    fun updatdResultPlay(resultList: List<ResultXX>) {
        this.resultList = resultList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_play, parent, false)
        return PlayViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: PlayViewHolder, position: Int) {
        holder.bindPlay(resultList[position])
    }

}