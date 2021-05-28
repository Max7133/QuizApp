package com.example.quizapp
// Maksim Pasnitsenko 1910066
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView  // I created RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)  // I set the LayoutManager to this RecyclerView

        val questions = ArrayList<WordsList>()  // data for the list

        questions.add(WordsList("Word 1","Mikroaaltouuni"))
        questions.add(WordsList("Word 2","Tuoli"))
        questions.add(WordsList("Word 3","Pöytä"))
        questions.add(WordsList("Word 4","Kissa"))
        questions.add(WordsList("Word 5","Karu"))
        questions.add(WordsList("Word 6","Kahvi"))
        questions.add(WordsList("Word 7","Kynä"))
        questions.add(WordsList("Word 8","Aurinko"))
        questions.add(WordsList("Word 9","Kirja"))
        questions.add(WordsList("Word 10","Lamppu"))

        val adapter = CustomAdapter(questions) // I'm passing the questions list

        recyclerView.adapter = adapter  // I putted this adapter to the RecyclerView

        // To go back from the RecyclerView to the MainActivity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        val intent =  Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return true
    }
}