package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var editText: EditText? = null
    private var addButton: MaterialButton? = null
    private lateinit var showButton: MaterialButton
    private lateinit var textView: TextView

    private val namesList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
    }

    private fun initViews() {
        editText = findViewById(R.id.editText_name)
        addButton = findViewById(R.id.add)
        showButton = findViewById(R.id.show)
        textView = findViewById(R.id.textView_list)
    }

    private fun initListeners() {
        addButton?.setOnClickListener {
            namesList.add(editText?.text.toString())
            editText?.setText("")
                Toast.makeText(this, "Добавлено", Toast.LENGTH_LONG).show()

            namesList.sort()
        }

        showButton.setOnClickListener {
            val text = namesList.distinct().joinToString (separator = "\n")
            textView.text = text

        }



    }
}