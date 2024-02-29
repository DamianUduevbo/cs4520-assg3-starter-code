package com.cs4520.assignment3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun performOperation(num1: String, num2: String, operation: String) {
        if (num1.isBlank() || num2.isBlank()) {
            _error.value = "Invalid input"
            return
        }

        try {
            val result = when (operation) {
                "add" -> num1.toDouble() + num2.toDouble()
                "subtract" -> num1.toDouble() - num2.toDouble()
                "multiply" -> num1.toDouble() * num2.toDouble()
                "divide" -> {
                    if (num2.toDouble() == 0.0) throw ArithmeticException("Cannot divide by zero")
                    num1.toDouble() / num2.toDouble()
                }
                else -> throw IllegalArgumentException("Invalid operation")
            }
            _result.value = result.toString()
        } catch (e: Exception) {
            _error.value = e.message
        }
    }
}
