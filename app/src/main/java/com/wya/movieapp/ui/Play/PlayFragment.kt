package com.wya.movieapp.ui.Play

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.wya.movieapp.R
import kotlinx.android.synthetic.main.fragment_play.*


class PlayFragment : Fragment() {
    lateinit var playAdapter: PlayAdapter
    lateinit var playViewModel: PlayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playViewModel = ViewModelProvider(this).get(PlayViewModel::class.java)
        playAdapter = PlayAdapter()
        recyclerViewPlay.apply {
            layoutManager=GridLayoutManager(context,3)
            adapter=playAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        playViewModel.getResultPlay()?.observe(viewLifecycleOwner, Observer { Play ->
            playAdapter.updatdResultPlay(Play.results)
        })
    }

    override fun onResume() {
        super.onResume()
        playViewModel.getLoadingPlay()
    }
}