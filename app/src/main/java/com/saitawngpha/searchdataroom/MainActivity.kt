package com.saitawngpha.searchdataroom

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.saitawngpha.searchdataroom.adapter.MyAdapter
import com.saitawngpha.searchdataroom.databinding.ActivityMainBinding
import com.saitawngpha.searchdataroom.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()
    private val myAdapter: MyAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter

        mainViewModel.readData.observe(this, {
            myAdapter.setData(it)
        })

        mainViewModel.insertData(com.saitawngpha.searchdataroom.data.Person("sai", "noom", 34))
        mainViewModel.insertData(com.saitawngpha.searchdataroom.data.Person("nang", "noom", 34))
        mainViewModel.insertData(com.saitawngpha.searchdataroom.data.Person("Ying", "noom", 34))
        mainViewModel.insertData(com.saitawngpha.searchdataroom.data.Person("Noung", "noom", 34))
        mainViewModel.insertData(com.saitawngpha.searchdataroom.data.Person("Nai", "noom", 34))
        mainViewModel.insertData(com.saitawngpha.searchdataroom.data.Person("King", "noom", 34))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            searchDatabase(query)
        }
        return true
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"

        mainViewModel.searchDatabase(searchQuery).observe(this, { list ->
            list.let {
                myAdapter.setData(it)
            }
        })
    }
}