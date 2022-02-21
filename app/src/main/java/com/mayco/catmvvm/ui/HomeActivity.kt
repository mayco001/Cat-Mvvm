package com.mayco.catmvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayco.catmvvm.R
import com.mayco.catmvvm.adapter.CatsAdapter
import com.mayco.catmvvm.databinding.ActivityHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()
    lateinit var binding: ActivityHomeBinding

    private lateinit var catsAdapter: CatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        viewModel.getCats()

        iniRecyclerView()

        viewModel.returnApi.observeForever { cats ->
            catsAdapter.items = cats
        }
    }

    private fun iniRecyclerView() {

        this.catsAdapter = CatsAdapter()
        binding.recy.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.recy.adapter = this.catsAdapter
    }
}
