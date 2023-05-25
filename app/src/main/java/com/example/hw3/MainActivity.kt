package com.example.hw3

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hw3.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCLicker()

    }

    private fun initCLicker() {
        with(binding) {
            btnOk.setOnClickListener {
                RetrofitService().api.searchImage(etKey.text.toString())
                    .enqueue(object : Callback<PixabayModel> {
                        override fun onResponse(
                            call: Call<PixabayModel>,
                            response: Response<PixabayModel>
                        ) {
                            if (response.isSuccessful) {
                                Log.e("ololo", "onResponse: ${response.body()?.hits}")
                            }
                        }

                        override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                            Log.e(TAG, "onFailure: ${t.message}")
                        }

                    })
            }
        }
    }
}