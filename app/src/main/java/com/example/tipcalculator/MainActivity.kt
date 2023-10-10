package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve the amount
        val etBillAmount: EditText = findViewById(R.id.billAmount)
        var etBillAmountTxt: String = etBillAmount.text.toString()

        // wait until an amount has been entered
        while(etBillAmountTxt.isEmpty()){

        }

        var billAmount: Double = etBillAmountTxt.toDouble()

        //Displayed percentage
        var displayTipPercentage: TextView = findViewById(R.id.tipPercentage)
        var seekBar: SeekBar = findViewById(R.id.slider)
        var tip: Double = 0.0

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                displayTipPercentage.text = "$progress% "
                tip = (progress * 0.01) * billAmount

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })



    }
}