package com.cs4520.assignment3

interface ICalculatorView {
    fun showResult(result: String)
    fun showError(message: String)
    fun clearInput()
}
