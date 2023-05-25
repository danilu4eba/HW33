package com.example.hw3

import java.net.URL


data class PixabayModel(
    val hits: ArrayList<ImageModel>
)

data class ImageModel(
    var largeImageURL: String
)
