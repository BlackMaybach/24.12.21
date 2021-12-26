package com.example.a241221.models


import java.io.Serializable

data class News(
    var name : String,
    var urlImg : String,
    var description: String,
    var category: String
):Serializable
