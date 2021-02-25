package com.example.watchfilmapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.watchfilmapp.Model.Film
import com.example.watchfilmapp.Model.IRVOnItemClick
import com.example.watchfilmapp.Model.RecyclerDataAdapter
import com.example.watchfilmapp.R

class MainFragment : Fragment(), IRVOnItemClick{

    companion object {
        fun newInstance() = MainFragment()
    }
    private lateinit var observer: Observer<ArrayList<Film>>
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        observer = Observer {setupRecyclerView(it)}
        viewModel.getData().observe(viewLifecycleOwner, observer)

    }

    fun setupRecyclerView(data: ArrayList<Film>){
        val linearLayoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val adapter: RecyclerDataAdapter = RecyclerDataAdapter(data, this)

        recyclerView = activity!!.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    override fun onItemClicked() {
        val intent = Intent(context, FilmInfo::class.java)
        startActivity(intent)
    }


}