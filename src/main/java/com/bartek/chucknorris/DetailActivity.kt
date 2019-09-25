package com.bartek.chucknorris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import com.bartek.chucknorris.MainActivity.Companion.EXTRA_STRING
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class DetailActivity : AppCompatActivity() {

    private lateinit var category: String
   @Inject
   lateinit var api: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        category = intent.getStringExtra(EXTRA_STRING) ?: "dev"

        DaggerApp
            .instance
            .injector
            .inject( this )



        categoryView.text = category

        fetchRandomJoke()

        refresh_button.setOnClickListener {
            fetchRandomJoke()
        }

        button.setOnClickListener {
            println("Button was clicked")
            finish()
        }

    }

    private fun fetchRandomJoke() {

        api.getJokes(category).enqueue(object : Callback<Jokes> {

            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {
                d("test", "onResponse")
                joke_view.text = response.body()?.value
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                d("test", "onFailure")
            }
        })

    }
}


