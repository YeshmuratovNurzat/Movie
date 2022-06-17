package com.etoolkit.news.presentions.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.etoolkit.news.R
import com.etoolkit.news.databinding.FragmentHomeBinding
import com.etoolkit.news.domian.model.MovieItem
import com.etoolkit.news.presentions.main.MAIN

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.getAllData()
        homeAdapter = HomeAdapter()
        binding.homeRecyclerView.adapter = homeAdapter
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(this.context)

        activity?.title = "Movie"

        //click recyclerView
        homeAdapter.setOnClick(object : HomeAdapter.SetClickListener{

            override fun onClick(movie: MovieItem) {
                val bundle = Bundle()
                bundle.putSerializable("movie",movie)
                Log.e("MyLog","bundle = $movie")
                MAIN.navController.navigate(R.id.action_homeFragment_to_detailFragment,bundle)
            }
        })

        homeViewModel.getAllMovieLiveData.observe(viewLifecycleOwner,{
            homeAdapter.setDataList(it.body()!!.results)

            Log.e("MyLog","Result =" + it.body()!!.results)
        })
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
