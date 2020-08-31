package com.bash.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var Result: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        Result = findViewById(R.id.result)

        btnCalculate.setOnClickListener{
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyField = false

            when{
                inputLength.isEmpty()->{
                    isEmptyField = true
                    edtLength.error = "Field ini tidak boleh kosong"
                }
                inputWidth.isEmpty()->{
                    isEmptyField = true
                    edtWidth.error = "Field ini tidak boleh kosong"
                }
                inputHeight.isEmpty()->{
                    isEmptyField = true
                    edtHeight.error = "Field ini tidak boleh kosong"
                }
                !isEmptyField ->{
                    val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                    Result.text = volume.toString()
                }
            }
        }

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT) as String
            Result.text = result
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, Result.text.toString())
    }
}