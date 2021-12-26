package com.example.a241221.adapters

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a241221.R
import com.example.a241221.fragments.ViewInfoNews
import com.example.a241221.models.News

class NewsAdapter(private var array: ArrayList<News>,
                  var context: FragmentActivity
) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // обьекты наших элементов(для ячеек)
        val title: TextView = view.findViewById<TextView>(R.id.getName)
        val image: ImageView = view.findViewById<ImageView>(R.id.getImg)
        val cat: TextView = view.findViewById<TextView>(R.id.getCat)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewNameCat = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_list_news, parent, false )
        return ViewHolder(viewNameCat)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]

        holder.title.text = item.name

        Glide.with(holder.itemView).load(item.urlImg).into(holder.image)
        holder.cat.text = item.category
        when(item.category) {
            "Спорт" -> {
                holder.cat.setTextColor(Color.parseColor("#FF1DA612"));
            }
            "Технологии" -> {
                holder.cat.setTextColor(Color.parseColor("#FF27D6AD"));
            }
            "Космос" -> {
                holder.cat.setTextColor(Color.parseColor("#FF6601DA"));
            }
            "Музыка" -> {
                holder.cat.setTextColor(Color.parseColor("#FFBD0000"));
            }

            else -> {
                holder.cat.setTextColor(Color.parseColor("#FF000000"));
            }
        }

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("viewAllNews", item)
            context.supportFragmentManager.beginTransaction()
                .replace(R.id.container, ViewInfoNews::class.java, bundle)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }

}