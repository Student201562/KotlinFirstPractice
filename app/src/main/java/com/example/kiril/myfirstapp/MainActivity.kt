package com.example.kiril.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView : RecyclerView = findViewById(R.id.my_recycler_view)

        // использование линейного менеджера компоновки
        var linearLayoutManager : LinearLayoutManager = LinearLayoutManager(this);

        my_recycler_view.layoutManager = linearLayoutManager

        Thread(Runnable {
            val client = OkHttpClient()
            val request = Request.Builder()
                    .url("https://api.github.com/users/Student201562/repos")
                    .build()
            val response = client.newCall(request).execute()
            val responseText = response.body()!!.string()
            val repos = Gson().fromJson(responseText, GitHubRepositoryInfo.List::class.java)

            runOnUiThread {
                val adapter = MyAdapter(repos)
                my_recycler_view.adapter = adapter
            }

            android.util.Log.d("Repos", repos.joinToString { it.name })

        }).start()
    }
}
