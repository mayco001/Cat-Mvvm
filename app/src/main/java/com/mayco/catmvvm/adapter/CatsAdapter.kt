package com.mayco.catmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mayco.catmvvm.R
import com.mayco.catmvvm.model.cat
import com.mayco.catmvvm.network.response.response.CatsResponse


class CatsAdapter : RecyclerView.Adapter<CatsAdapter.CatsViewHolder>() {


//    val items = listOf(
//
//
//        cat(id = "5bacafbbb3680b000f83435f"),
//        cat(id = "61009bfbcaacc400184f6b2b"),
//        cat(id = "595f280c557291a9750ebf80"),
//        cat(id = "595f280e557291a9750ebf9f")
//
//    )

    val items: List<CatsResponse> = ArrayList()








    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        return CatsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cat_layout, parent, false))
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {

        when(holder) {
            is CatsViewHolder ->{
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }



    class CatsViewHolder constructor(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView){

        private val imageCat = itemView.findViewById<ImageView>(R.id.catfoto)

        fun bind(cat : cat){

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