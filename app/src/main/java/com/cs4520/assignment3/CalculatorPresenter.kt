package com.cs4520.assignment3

class CalculatorPresenter(private val view: ICalculatorView) {
    fun performOperation(num1: String, num2: String, operation: String) {
        if (num1.isBlank() || num2.isBlank()) {
            view.showError("Invalid input")
            return
        }

        val result = when (operation) {
            "add" -> num1.toDouble() + num2.toDouble()
            "subtract" -> num1.toDouble() - num2.toDouble()
            "multiply" -> num1.toDouble() * num2.toDouble()
            "divide" -> {
                if (num2.toDouble() == 0.0) {
                    view.showError("Cannot divide by zero")
                    return
                }
                num1.toDouble() / num2.toDouble()
            }
            else -> null
        }

        result?.let {
            view.showResult(it.toString())
        } ?: view.showError("Invalid operation")
    }
}
