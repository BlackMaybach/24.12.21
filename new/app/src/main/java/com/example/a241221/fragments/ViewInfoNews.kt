package com.example.a241221.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.a241221.R
import com.example.a241221.models.News


class ViewInfoNews : Fragment() {

    lateinit var name : TextView
    lateinit var image : ImageView
    lateinit var desc : TextView
    lateinit var cat : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewSecondFragment = inflater.inflate(R.layout.fragment_view_info_news, container, false)

        name = viewSecondFragment.findViewById(R.id.viewName)
        desc = viewSecondFragment.findViewById(R.id.viewDesc)
        cat = viewSecondFragment.findViewById(R.id.viewCat)
        image = viewSecondFragment.findViewById(R.id.viewImg)

        // arguments - принимаем данные с ключом (айдишка)
        val category = arguments?.getSerializable("viewAllNews") as News

        when(category.category) {
            "Спорт" -> {
                cat.setTextColor(Color.parseColor("#FF1DA612"));
            }
            "Технологии" -> {
                cat.setTextColor(Color.parseColor("#FF27D6AD"));
            }
            "Космос" -> {
                cat.setTextColor(Color.parseColor("#FF6601DA"));
            }
            "Музыка" -> {
                cat.setTextColor(Color.parseColor("#FFBD0000"));
            }

            else -> {
                cat.setTextColor(Color.parseColor("#FF000000"));
            }
        }

        name.text = category.name
        desc.text = category.description
        cat.text = category.category
        Glide.with(this).load(category.urlImg).into(image)

        return viewSecondFragment
    }

    }
