package com.example.calculadora


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNumL: EditText = findViewById(R.id.edit_num1)
        val editNumR: EditText = findViewById(R.id.edit_num2)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val txtNum: TextView = findViewById(R.id.txt_number)
        val txtSymbol: TextView = findViewById(R.id.txt_symbol)

        val btnSum: Button = findViewById(R.id.btn_sum)
        val btnMinus: Button = findViewById(R.id.btn_minus)
        val btnMultiply: Button = findViewById(R.id.btn_multiply)
        val btnDivide: Button = findViewById(R.id.btn_divide)


        btnSum.setOnClickListener {
            val leftNum = editNumL.text.toString().toIntOrNull()?:0
            val rightNum = editNumR.text.toString().toIntOrNull()?:0

            text(txtResult)
            sum(leftNum, rightNum, txtNum, txtSymbol)
        }

        btnMinus.setOnClickListener {
            val leftNum = editNumL.text.toString().toIntOrNull()?:0
            val rightNum = editNumR.text.toString().toIntOrNull()?:0

            text(txtResult)
            minus(leftNum, rightNum, txtNum, txtSymbol)
        }


        btnMultiply.setOnClickListener {
            val leftNum = editNumL.text.toString().toIntOrNull()?:0
            val rightNum = editNumR.text.toString().toIntOrNull()?:0

            text(txtResult)
            multiply(leftNum, rightNum, txtNum, txtSymbol)
        }

        btnDivide.setOnClickListener {
            val leftNum = editNumL.text.toString().toIntOrNull()?:0
            val rightNum = editNumR.text.toString().toIntOrNull()?:0

            text(txtResult)
            divide(leftNum, rightNum, txtNum, txtSymbol)
        }

    }

    private fun text(txtResult: TextView){

        txtResult.text = "Resultado"
    }

    private fun sum(leftNum: Int, rightNum: Int, txtNum: TextView, symbol: TextView){
        symbol.text = "+"
        val result = leftNum + rightNum
        txtNum.text = result.toString()
    }

    private fun minus(leftNum: Int, rightNum: Int, txtNum: TextView, symbol: TextView){
        symbol.text = "-"
        val result = leftNum - rightNum
        txtNum.text = result.toString()
    }

    private fun multiply(leftNum: Int, rightNum: Int, txtNum: TextView, symbol: TextView){
        symbol.text = "*"
        val result = leftNum * rightNum
        txtNum.text = result.toString()
    }

    private fun divide(leftNum: Int, rightNum: Int, txtNum: TextView, symbol: TextView){
        symbol.text = "/"
        val left = leftNum.toDouble()
        val right = rightNum.toDouble()
        if (left != 0.0 && right != 0.0){
            val result = left / right
            txtNum.text = result.toString()
        }else{
            txtNum.text = "Erro"
        }
    }

}