package com.example.calculator_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var inputNumber: EditText? = null

    private var buttonNumber1: Button? = null
    private var buttonNumber2: Button? = null
    private var buttonNumber3: Button? = null
    private var buttonNumber4: Button? = null
    private var buttonNumber5: Button? = null
    private var buttonNumber6: Button? = null
    private var buttonNumber7: Button? = null
    private var buttonNumber8: Button? = null
    private var buttonNumber9: Button? = null
    private var buttonNumber0: Button? = null
    private var buttonPoint: Button? = null

    private var buttonPlus: Button? = null
    private var buttonEqual: Button? = null
    private var buttonDivide: Button? = null
    private var buttonMultiply: Button? = null
    private var buttonSqr: Button? = null
    private var buttonSqrt: Button? = null
    private var buttonMinus: Button? = null
    private var buttonPercent: Button? = null
    private var buttonAC: Button? = null
    private var buttonClearOneChar: Button? = null
    private var buttonSin: Button? = null
    private var buttonCos: Button? = null
    private var buttonTg: Button? = null
    private var buttonCtg: Button? = null
    private var buttonSqrNM: Button? = null
    private var buttonLog: Button? = null
    private var buttonLn: Button? = null
    private var buttonFac: Button? = null

    private var number1 = 0.0
    private var number2 = 0.0
    private var result = 0.0

    internal enum class Sign {
        PLUS, MINUS, MUL, DIV, SQR, SQRT, PER, SIN, COS, TG, CTG, SQR1, LN, LOG, FAC
    }

    private var sign: Sign? = null

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("temp", inputNumber!!.text.toString())
        outState.putDouble("number1", number1)
        outState.putDouble("number2", number2)
        outState.putSerializable("sign", sign)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputNumber = findViewById(R.id.text)

        buttonNumber1 = findViewById(R.id.bt_1)
        buttonNumber2 = findViewById(R.id.bt_2)
        buttonNumber3 = findViewById(R.id.bt_3)
        buttonNumber4 = findViewById(R.id.bt_4)
        buttonNumber5 = findViewById(R.id.bt_5)
        buttonNumber6 = findViewById(R.id.bt_6)
        buttonNumber7 = findViewById(R.id.bt_7)
        buttonNumber8 = findViewById(R.id.bt_8)
        buttonNumber9 = findViewById(R.id.bt_9)
        buttonNumber0 = findViewById(R.id.bt_0)

        buttonPlus = findViewById(R.id.bt_plus)
        buttonEqual = findViewById(R.id.bt_eq)
        buttonSqr = findViewById(R.id.bt_sqr)
        buttonDivide = findViewById(R.id.bt_div)
        buttonSqrt = findViewById(R.id.bt_sqrt)
        buttonMultiply = findViewById(R.id.bt_mult)
        buttonMinus = findViewById(R.id.bt_minus)
        buttonPercent = findViewById(R.id.percent)
        buttonClearOneChar = findViewById(R.id.bt_cancel)
        buttonAC = findViewById(R.id.bt_AC)
        buttonSin = findViewById(R.id.bt_sin)
        buttonCos = findViewById(R.id.bt_cos)
        buttonTg = findViewById(R.id.bt_tg)
        buttonCtg = findViewById(R.id.bt_ctg)
        buttonSqrNM = findViewById(R.id.bt_squareNM)
        buttonFac = findViewById(R.id.bt_fac)
        buttonLn = findViewById(R.id.bt_ln)
        buttonLog = findViewById(R.id.bt_log)
        buttonPoint = findViewById(R.id.bt_point)

        buttonNumber1!!.setOnClickListener(this)
        buttonNumber2!!.setOnClickListener(this)
        buttonNumber3!!.setOnClickListener(this)
        buttonNumber4!!.setOnClickListener(this)
        buttonNumber5!!.setOnClickListener(this)
        buttonNumber6!!.setOnClickListener(this)
        buttonNumber7!!.setOnClickListener(this)
        buttonNumber8!!.setOnClickListener(this)
        buttonNumber9!!.setOnClickListener(this)
        buttonNumber0!!.setOnClickListener(this)

        buttonPlus!!.setOnClickListener(this)
        buttonEqual!!.setOnClickListener(this)
        buttonMultiply!!.setOnClickListener(this)
        buttonSqrt!!.setOnClickListener(this)
        buttonDivide!!.setOnClickListener(this)
        buttonMinus!!.setOnClickListener(this)
        buttonSqr!!.setOnClickListener(this)
        buttonClearOneChar!!.setOnClickListener(this)
        buttonAC!!.setOnClickListener(this)
        buttonPercent!!.setOnClickListener(this)
        buttonSin!!.setOnClickListener(this)
        buttonCos!!.setOnClickListener(this)
        buttonTg!!.setOnClickListener(this)
        buttonCtg!!.setOnClickListener(this)
        buttonSqrNM!!.setOnClickListener(this)
        buttonLog!!.setOnClickListener(this)
        buttonLn!!.setOnClickListener(this)
        buttonFac!!.setOnClickListener(this)
        buttonPoint!!.setOnClickListener(this)

        if (savedInstanceState != null) {
            super.onRestoreInstanceState(savedInstanceState)
            number1 = savedInstanceState.getDouble("number1")
            number2 = savedInstanceState.getDouble("number2")
            sign = savedInstanceState.getSerializable("sign") as Sign?
            inputNumber?.setText(savedInstanceState.getString("temp"))
        }
    }

    private fun calculateFactorial(n: Double): Double {
        var num = 1
        var i = 1
        while (i <= n) {
            num *= i
            i++
        }
        return num.toDouble()
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        when (view.id) {
            R.id.bt_1 -> {
                inputNumber!!.append("1")
            }
            R.id.bt_2 -> {
                inputNumber!!.append("2")
            }
            R.id.bt_3 -> {
                inputNumber!!.append("3")
            }
            R.id.bt_4 -> {
                inputNumber!!.append("4")
            }
            R.id.bt_5 -> {
                inputNumber!!.append("5")
            }
            R.id.bt_6 -> {
                inputNumber!!.append("6")
            }
            R.id.bt_7 -> {
                inputNumber!!.append("7")
            }
            R.id.bt_8 -> {
                inputNumber!!.append("8")
            }
            R.id.bt_9 -> {
                inputNumber!!.append("9")
            }
            R.id.bt_0 -> {
                inputNumber!!.append("0")
            }
            R.id.bt_plus -> {
                sign = Sign.PLUS
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")

                }
            }
            R.id.bt_minus -> {
                sign = Sign.MINUS
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")

                } else inputNumber!!.setText("-")
            }
            R.id.bt_div -> {
                sign = Sign.DIV
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")

                }
            }
            R.id.bt_mult -> {
                sign = Sign.MUL
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")

                }
            }
            R.id.bt_sqr -> {
                sign = Sign.SQR
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")

                }
            }
            R.id.bt_sqrt -> {
                sign = Sign.SQRT
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")

                }
            }
            R.id.percent -> {
                sign = Sign.PER
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_AC -> {
                inputNumber!!.setText("")
            }
            R.id.bt_cancel -> {
                if (inputNumber!!.length() != 0) {
                    var number: String = inputNumber!!.text.toString()
                    number = number.substring(0, number.length - 1)
                    inputNumber!!.setText(number)
                }
            }
            R.id.bt_sin -> {
                sign = Sign.SIN
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_cos -> {
                sign = Sign.COS
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_tg -> {
                sign = Sign.TG
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_ctg -> {
                sign = Sign.CTG
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_squareNM -> {
                sign = Sign.SQR1
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_fac -> {
                sign = Sign.FAC
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toInt().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_ln -> {
                sign = Sign.LN
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_log -> {
                sign = Sign.LOG
                if (inputNumber!!.text.isNotEmpty()) {
                    number1 = inputNumber!!.text.toString().toFloat().toDouble()
                    inputNumber!!.setText("")
                }
            }
            R.id.bt_point -> {
                if (inputNumber!!.text.isNotEmpty()) {
                    val number = inputNumber!!.text.toString()
                    val point = number.contains(".")
                    if (!point) inputNumber!!.setText("$number.")
                }
            }
            R.id.bt_eq -> {
                if (sign == Sign.PLUS) {
                    number2 = inputNumber!!.text.toString().toFloat().toDouble()
                    result = number1 + number2
                } else if (sign == Sign.MINUS) {
                    number2 = inputNumber!!.text.toString().toFloat().toDouble()
                    result = number1 - number2
                } else if (sign == Sign.MUL) {
                    number2 = inputNumber!!.text.toString().toFloat().toDouble()
                    result = number1 * number2
                } else if (sign == Sign.DIV) {
                    number2 = inputNumber!!.text.toString().toFloat().toDouble()
                    result = number1 / number2
                } else if (sign == Sign.SQR) {
                    result = number1.pow(2.0)
                } else if (sign == Sign.SQRT) {
                    result = sqrt(number1)
                } else if (sign == Sign.PER) {
                    result = number1 / 100
                } else if (sign == Sign.SIN) {
                    result = sin(number1)
                } else if (sign == Sign.COS) {
                    result = cos(number1)
                } else if (sign == Sign.TG) {
                    result = tan(number1)
                } else if (sign == Sign.CTG) {
                    result = cos(number1) / sin(number1)
                } else if (sign == Sign.LN) {
                    result = log10(number1)
                } else if (sign == Sign.LOG) {
                    result = log2(number1)
                } else if (sign == Sign.FAC) {
                    val a: Double = calculateFactorial(number1)
                    result = a
                } else if (sign == Sign.SQR1) {
                    number2 = inputNumber!!.text.toString().toFloat().toDouble()
                    result = number1.pow(number2)
                }
                inputNumber!!.setText(result.toString())
            }
        }
    }
}