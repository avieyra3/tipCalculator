package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve the amount
        var etBillAmount: EditText = findViewById(R.id.billAmount)
        var billAmount: Int = etBillAmount.text.toString().toInt()




    }
}