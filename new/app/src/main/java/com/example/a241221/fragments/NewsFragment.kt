package com.example.a241221.fragments

import android.os.Bundle
import android.provider.SyncStateContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a241221.Constants
import com.example.a241221.R

import com.example.a241221.adapters.NewsAdapter


class NewsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val viewFirstFragment = inflater.inflate(R.layout.fragment_news, container, false)
        val recyclerView = viewFirstFragment.findViewById<RecyclerView>(R.id.recyclerNews)

        // adapter - работает с массивом что бы его отрисовать,
        recyclerView.adapter = NewsAdapter(Constants.categories, requireActivity())
        return viewFirstFragment
    }
}

