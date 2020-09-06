package com.wya.movieapp.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.wya.movieapp.R
import com.wya.movieapp.ui.model.Detail
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_rated.view.*

class DetailFragment : Fragment() {

    lateinit var detailViewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var detaisArgs = arguments?.let {
            DetailFragmentArgs.fromBundle(it)
        }
        var detailsId = detaisArgs?.detailsID

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.getLoading(detailsId!!)
        observeViewModel()
    }

    private fun observeViewModel() {
        var imgURL: String = "http://image.tmdb.org/t/p/w500/"
        detailViewModel.getDetail().observe(viewLifecycleOwner, Observer { Detail ->
            //Picasso.get().load(imgURL + Detail.backdrop_path).into(imageViewDetail)
            tvDetail.text=Detail.title
        })
    }
}