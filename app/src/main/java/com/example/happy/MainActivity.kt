package com.example.happy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var feelingViewModel: FeelingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = FeelingAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        feelingViewModel = ViewModelProvider(this).get(FeelingViewModel::class.java)

        feelingViewModel.allFeelings.observe(this,
            Observer { feelingList: List<Feeling> ->
                feelingList.let {
                    if (it.isNotEmpty()) {
                        adapter.setFeeling(it)
                        Toast.makeText(
                            applicationContext,
                            "Num:" + it.size,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        )
    }
}
