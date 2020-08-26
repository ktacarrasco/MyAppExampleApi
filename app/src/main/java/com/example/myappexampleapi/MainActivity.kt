package com.example.myappexampleapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myappexampleapi.network.ClientRetrofit
import com.example.myappexampleapi.pojo.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadApiData()
        delete()


        }

    private fun loadApiData() {
        val service = ClientRetrofit.retrofitInstance()
        val call = service.groupList()



       call.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                Log.d("TAG",response.body().toString())
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("ERROR",t.message.toString())
            }



        })

    }

    private fun delete(){

        val service = ClientRetrofit.retrofitInstance()
        val call = service.deletePost(1)
        call.enqueue(object : Callback<Void> {


            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Log.d("DELETE",response.body().toString())
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("ERROR",t.message.toString())
            }

        })
    }
}