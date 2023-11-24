package com.example.simplecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var currentInputNumber: String = "0"
    private var currentInput: String = "0"
    private  var equalFlag: Int = 0
    private var operatorFlag: Int = 0
    private var currentOperator: String? = null
    private var firstOperand: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)
    }

    fun onButtonClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        when {
            buttonText.isDigitsOnly() -> handleDigitInput(buttonText)
            buttonText in setOf("+", "-", "x", "/") -> handleOperatorInput(buttonText)
            buttonText == "=" -> {
                handleEqualsInput()
                operatorFlag = 0
            }
            buttonText == "+/-" -> handleToggleSign()
            buttonText == "CE" -> handleClearEntry()
            buttonText == "C" -> handleClear()
            buttonText == "BS" -> handleBackspace()
            buttonText == "." -> handleDecimalInput()
        }
        updateDisplay()
    }

    private fun handleDigitInput(digit: String) {
        if(equalFlag == 1){
            currentInputNumber = "0"
            equalFlag = 0
        }
        if (currentInputNumber == "0" || currentInputNumber == "-0") {
            currentInput = digit
            currentInputNumber = digit
        } else {
            currentInput += digit
            currentInputNumber += digit
        }
    }

    private fun handleOperatorInput(operator: String) {
        if(operatorFlag == 1){
            handleEqualsInput()
            firstOperand = currentInputNumber.toInt()
            currentInputNumber = "0"
            currentOperator = operator
            //Display operator on the display
            currentInput += operator
            equalFlag = 0
            operatorFlag = 1
        } else {
            firstOperand = currentInputNumber.toInt()
            currentInputNumber = "0"
            currentOperator = operator
            //Display operator on the display
            currentInput = operator
            equalFlag = 0
            operatorFlag = 1
        }
    }

    private fun handleEqualsInput() {
        val secondOperand = currentInputNumber.toInt()
        when (currentOperator) {
            "+" -> {
                currentInput = (firstOperand + secondOperand).toString()
                currentInputNumber = (firstOperand + secondOperand).toString()
            }
            "-" -> {
                currentInput = (firstOperand - secondOperand).toString()
                currentInputNumber = (firstOperand - secondOperand).toString()
            }
            "x" -> {
                currentInputNumber = (firstOperand * secondOperand).toString()
                currentInput = (firstOperand * secondOperand).toString()
            }
            "/" -> {
                if (secondOperand != 0) {
                    currentInput = (firstOperand / secondOperand).toString()
                    currentInputNumber = (firstOperand / secondOperand).toString()
                } else {
                    currentInput = "Error"
                    currentInputNumber = "Error"
                }
            }
        }
        equalFlag = 1
        currentOperator = null
    }

    private fun handleToggleSign() {
        if (currentInputNumber.startsWith("-")) {
            currentInputNumber = currentInputNumber.substring(1)
            currentInput = currentInput.substring(1)
        } else {
            currentInputNumber = "-$currentInputNumber"
            currentInput = "-$currentInput"
        }
    }

    private fun handleClearEntry() {
        currentInputNumber = "0"
        currentInput = "0"
        equalFlag = 0
    }

    private fun handleClear() {
        currentInputNumber = "0"
        currentInput = "0"
        currentOperator = null
        firstOperand = 0
        equalFlag = 0
    }

    private fun handleBackspace() {
        if (currentInput.length > 1) {
            currentInput = currentInput.substring(0, currentInput.length - 1)
            currentInputNumber = currentInputNumber.substring(0, currentInputNumber.length - 1)
        } else {
            currentInput = "0"
            currentInputNumber = "0"
        }
    }

    private fun handleDecimalInput() {
        if (!currentInput.contains(".")) {
            currentInputNumber += "."
            currentInput += "."
        }
    }

    private fun updateDisplay() {
        tvDisplay.text = currentInput
    }
}
