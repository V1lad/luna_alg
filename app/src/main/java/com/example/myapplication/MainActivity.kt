package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editA: EditText
    private lateinit var btn: Button
    private lateinit var res: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editA = findViewById(R.id.editTextA)
        btn = findViewById(R.id.button)
        res = findViewById(R.id.textView)

        btn.setOnClickListener {
            val inputString = editA.text.toString()
            val filteredText = inputString.filter { it.isDigit() }
            var sum  = 0
            val nDigits : Int = filteredText.length
            val parity : Int = nDigits % 2
            for (i in 0..<nDigits) {
                var digit : Int = filteredText[i].toString().toInt()
                if (i % 2 == parity){
                    digit *=  2
                    if (digit > 9){
                        digit -=  9
                    }
                }
                sum +=  digit
            }
            val result = (sum % 10) == 0
            if (result){
                res.text = "True"
            }
            else {
                res.text = "False"
            }

            }

        }

    }
