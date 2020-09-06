package com.wya.movieapp.ui.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.wya.movieapp.R
import com.wya.movieapp.ui.model.Popular
import kotlinx.android.synthetic.main.fragment_popular.*

class PopularFragment : Fragment() {
    lateinit var popularViewModel: PopularViewModel
    lateinit var popularAdapter: PopularAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularViewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
        popularAdapter = PopularAdapter()
        recyclerviewPopular.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = popularAdapter
        }
        ObserveViewModel()
    }

    private fun ObserveViewModel() {
        popularViewModel.getResultPopular()?.observe(viewLifecycleOwner, Observer { Popular ->
            popularAdapter.updateResultPopular(Popular.results)
        })
    }

    override fun onResume() {
        super.onResume()
        popularViewModel.getLoadingPopular()
    }

}