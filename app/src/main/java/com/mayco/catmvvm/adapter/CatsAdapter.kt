package com.mayco.catmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mayco.catmvvm.R
import com.mayco.catmvvm.network.response.response.CatsResponse
import kotlin.properties.Delegates


class CatsAdapter : RecyclerView.Adapter<CatsAdapter.CatsViewHolder>() {


    var items: List<CatsResponse> by Delegates.observable(emptyList()) { _, old, new ->
        if (old != new) notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        return CatsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cat_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {

        val catsResponse = items[position]
        holder.bind(catsResponse)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class CatsViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {

        private val imageCat = itemView.findViewById<ImageView>(R.id.catfoto)

        fun bind(cat: CatsResponse) {

            val requestOptions = RequestOptions()
                .placeholder(R.color.black)
                .error(R.drawable.ic_launcher_foreground)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load("https://cataas.com/c/" + cat.id)
                .into(imageCat)

        }


    }
}
