package com.wya.movieapp.ui.rated

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wya.movieapp.R
import com.wya.movieapp.ui.model.Result
import kotlinx.android.synthetic.main.item_rated.view.*

class RatedAdapter(var resultList: List<Result> = ArrayList<Result>()) :
    RecyclerView.Adapter<RatedAdapter.RatedViewHolder>() {
    var mClickListener: ClickListener?=null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener=clickListener
    }

    inner class RatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
        lateinit var result: Result
        init {
            itemView.setOnClickListener(this)
        }
        fun bindRated(result: Result) {
            this.result=result
            Picasso.get().load("https://image.tmdb.org/t/p/w500/" + result.poster_path)
                .into(itemView.imageViewRated)
            itemView.txtTitleRated.text= result.title
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(result)
        }
    }

    fun updateResult(resultList: List<Result>) {
        this.resultList = resultList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatedViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_rated, parent, false)
        return RatedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: RatedViewHolder, position: Int) {
        holder.bindRated(resultList[position])
    }

    interface ClickListener {
        fun onClick(result: Result)
    }
}