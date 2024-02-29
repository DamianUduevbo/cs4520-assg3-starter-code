package com.cs4520.assignment3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class MVVMFragment : Fragment() {
    private val viewModel: CalculatorViewModel by viewModels()
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button

    private lateinit var inputField1: EditText
    private lateinit var inputField2: EditText

    private lateinit var resultTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mvvm, container, false)
        addButton = view.findViewById(R.id.add_button)
        subtractButton = view.findViewById(R.id.subtract_button)
        multiplyButton = view.findViewById(R.id.multiply_button)
        divideButton = view.findViewById(R.id.divide_button)

        inputField1 = view.findViewById(R.id.inputValue1)
        inputField2 = view.findViewById(R.id.inputValue2)

        resultTextView = view.findViewById(R.id.mvp_result)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner) { result ->
            resultTextView.text = result
            clearInputs()
        }

        viewModel.error.observe(viewLifecycleOwner) { message ->
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }

        setupButtonClickListeners()
    }

    private fun setupButtonClickListeners() {
        addButton.setOnClickListener {
            viewModel.performOperation(
                inputField1.text.toString(),
                inputField2.text.toString(),
                "add"
            )

            clearInputs()
        }

        subtractButton.setOnClickListener {
            viewModel.performOperation(
                inputField1.text.toString(),
                inputField2.text.toString(),
                "subtract"
            )

            clearInputs()
        }

        multiplyButton.setOnClickListener {
            viewModel.performOperation(
                inputField1.text.toString(),
                inputField2.text.toString(),
                "multiply"
            )

            clearInputs()
        }

        divideButton.setOnClickListener {
            viewModel.performOperation(
                inputField1.text.toString(),
                inputField2.text.toString(),
                "divide"
            )

            clearInputs()
        }
    }

    private fun clearInputs() {
        inputField1.text.clear()
        inputField2.text.clear()
    }
}
