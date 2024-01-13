package com.example.sharedprefapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText:EditText=findViewById(R.id.editText)
         textView=findViewById(R.id.TextView2)
        val btn:Button=findViewById(R.id.btn)

        DisplaySavedText()


        btn.setOnClickListener(){
            val enteredText:String=editText.text.toString()
            SaveNameInSharedPreference(enteredText)
        }
    }

    private fun SaveNameInSharedPreference(enteredText:String){
        //Opening the shared preferences
        val sharedPreference:SharedPreferences=getSharedPreferences(
            "UserName",
            MODE_PRIVATE //(for not to share with others)

        )

        //writing data in shared preferences
        val editor:SharedPreferences.Editor=sharedPreference.edit()

        editor.putString("Name",enteredText)
        editor.commit()
    }

    //Reading data from shared preferences
    fun DisplaySavedText(){
        val sharedPreferences:SharedPreferences=
            getSharedPreferences("UserName", MODE_PRIVATE)

        val s1:String?=sharedPreferences.getString(
            "Name",""
        )

        textView.setText(s1)
    }
}