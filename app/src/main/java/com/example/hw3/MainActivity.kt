package com.example.hw3

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hw3.databinding.ActivityMainBinding
import layout.PixAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var adapter = PixAdapter(arrayListOf())
    var page = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCLicker()

    }

    private fun initCLicker() {
        with(binding) {
            btnChange.setOnClickListener {
                ++page
                request()

            }
            btnOk.setOnClickListener {
                page = 1
                adapter.list.clear()
                request()
            }
        }
    }

    private fun ActivityMainBinding.request() {
        RetrofitService().api.searchImage(etKey.text.toString(), page = page)
            .enqueue(object : Callback<PixabayModel> {
                override fun onResponse(
                    call: Call<PixabayModel>,
                    response: Response<PixabayModel>
                ) {
                    if (response.isSuccessful) {
                        adapter.list.addAll(response.body()?.hits!!)
                        recyclerView.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }

            })
    }
}