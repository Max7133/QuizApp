package com.example.quizapp
// Maksim Pasnitsenko 1910066
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// I'm passing word list to this adapter
class CustomAdapter (val questionList: ArrayList<WordsList>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {  // I defined TextView's here
        val textViewQuestion = itemView.findViewById(R.id.textViewWord) as TextView
        val textViewQuestionOne = itemView.findViewById(R.id.textViewWordOne) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { // it creates ViewHolder, and for this it uses list_layout.xml, and this list_layout will be generated for each item in the RecyclerView
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {  // it will bind the values to the textView so it will show then later in the RecyclerView
        val quest: WordsList = questionList[position]
        holder.textViewQuestion.text = quest.word
        holder.textViewQuestionOne.text = quest.answer
    }

    override fun getItemCount(): Int { // returns the size of questionList from the CustomAdapter class and it will define the size of RecyclerView
        return questionList.size
    }
}