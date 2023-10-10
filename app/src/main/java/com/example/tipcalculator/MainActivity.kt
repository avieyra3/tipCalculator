package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve input data
        val etBillAmount: EditText = findViewById(R.id.billAmount)
        val seekBar: SeekBar = findViewById(R.id.slider)

        // Retrieve objects for displaying data
        val displayTipPercentage: TextView = findViewById(R.id.tipPercentage)
        val displayTipAmt: TextView = findViewById(R.id.tipAmt)
        val displayTotalAmt: TextView = findViewById(R.id.totalAmt)

        var billAmount: Double = 0.0

        etBillAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // Update billAmount and UI when text changes
                billAmount = s?.toString()?.toDoubleOrNull() ?: 0.0
                updateUI(billAmount, seekBar.progress, displayTipPercentage, displayTipAmt, displayTotalAmt)
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update UI when SeekBar changes
                updateUI(billAmount, progress, displayTipPercentage, displayTipAmt, displayTotalAmt)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    private fun updateUI(billAmount: Double, progress: Int, displayTipPercentage: TextView, displayTipAmt: TextView, displayTotalAmt: TextView) {
        val tipPercentage = progress
        val tip = (tipPercentage * 0.01) * billAmount
        val total = billAmount + tip

        val formattedTip = "%.2f".format(tip)
        val formattedTotal = "%.2f".format(total)
        // Update UI
        displayTipPercentage.text = "$tipPercentage% "
        displayTipAmt.text = "$formattedTip"
        displayTotalAmt.text = "$formattedTotal"
    }
}