package com.happypills.ui.pills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.happypills.R
import com.happypills.ui.pills.utils.PillListGridRecyclerView
import kotlinx.android.synthetic.main.fragment_pills.view.*

class PillsFragment : Fragment() {

    private lateinit var pillsViewModel: PillsViewModel
    private lateinit var recyclerView: RecyclerView
    private var recyclerViewAdapter = PillListGridRecyclerView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pillsViewModel =
                ViewModelProviders.of(this).get(PillsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pills, container, false)

        setupRecyclerView(root)

        return root
    }

    private fun setupRecyclerView(view : View?){
        view?.let {
            recyclerView = it.pills_recycler_view
            recyclerView.layoutManager = GridLayoutManager(context, 2)
            recyclerView.adapter = recyclerViewAdapter
            recyclerViewAdapter.setPillsList(pillsViewModel.pillsList.value!!)
        }
    }

}