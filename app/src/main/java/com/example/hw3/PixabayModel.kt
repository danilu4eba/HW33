package com.example.hw3

data class PixabayModel(
    val hits: ArrayList<ImageModel>
)

data class ImageModel(
    var LargeImageUrl: String
)
