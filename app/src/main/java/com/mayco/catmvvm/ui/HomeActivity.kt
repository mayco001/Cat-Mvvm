package com.mayco.catmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.mayco.catmvvm.R
import com.mayco.catmvvm.databinding.ActivityHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        viewModel.getCats()


        viewModel.returnApi.observeForever {
            binding.textView.text = it[0].created_at

            Glide.with(binding.imageViewCat.context).load( "https://cataas.com/c/"+ it[1].id).into(binding.imageViewCat)
        }
    }
}