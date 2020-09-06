package com.wya.movieapp.ui.rated

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.wya.movieapp.R
import com.wya.movieapp.ui.model.Result
import kotlinx.android.synthetic.main.fragment_rated.*

class RatedFragment : Fragment(),RatedAdapter.ClickListener {
    lateinit var ratedViewModel: RatedViewModel
    lateinit var ratedAdapter: RatedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rated, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ratedViewModel= ViewModelProvider(this).get(RatedViewModel::class.java)
        ratedAdapter= RatedAdapter()

        recyclerviewRated.apply {
            layoutManager=GridLayoutManager(context,3)
            adapter=ratedAdapter
        }
        ratedAdapter.setOnClickListener(this)
        ObserveViewModel()
    }
    private fun ObserveViewModel(){
        ratedViewModel.getResultRated()?.observe(viewLifecycleOwner, Observer { Rated ->
            ratedAdapter.updateResult(Rated.results)
        })
    }

    override fun onResume() {
        super.onResume()
        ratedViewModel.getLoading()
    }

    override fun onClick(result: Result) {
        var action=RatedFragmentDirections.actionNavRatedToDetailFragment(result.id)
        findNavController().navigate(action)
    }
}