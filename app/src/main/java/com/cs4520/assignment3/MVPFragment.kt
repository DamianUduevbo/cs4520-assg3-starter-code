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

class MVPFragment : Fragment(), ICalculatorView {
    private lateinit var presenter: CalculatorPresenter;
    private lateinit var inputField1: EditText;
    private lateinit var inputField2: EditText;
    private lateinit var resultField: TextView;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeFragment", "onCreateView")
        super.onCreate(savedInstanceState)
        presenter = CalculatorPresenter(this)

        val view = inflater.inflate(R.layout.fragment_mvp, container, false)

        inputField1 = view.findViewById<EditText>(R.id.inputValue1);
        inputField2 = view.findViewById<EditText>(R.id.inputValue2);
        resultField = view.findViewById<TextView>(R.id.mvp_result);

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addButton = view.findViewById<Button>(R.id.add_button)
        val subtractButton = view.findViewById<Button>(R.id.subtract_button)
        val multiplyButton = view.findViewById<Button>(R.id.multiply_button)
        val divideButton = view.findViewById<Button>(R.id.divide_button)

        addButton.setOnClickListener {
            presenter.performOperation(
                inputField1.text.toString(),
                inputField2.text.toString(),
                "add"
            )

            clearInput()
        }

        subtractButton.setOnClickListener {
            presenter.performOperation(
                inputField1.text.toString(),
                inputField2.text.toString(),
                "subtract"
            )

            clearInput()
        }

        multiplyButton.setOnClickListener {
            presenter.performOperation(
                inputField1.text.toString(),
                inputField2.text.toString(),
                "multiply"
            )

            clearInput()
        }

        divideButton.setOnClickListener {
            presenter.performOperation(
                inputField1.text.toString(),
                inputField2.text.toString(),
                "divide"
            )

            clearInput()
        }
    }

    override fun showResult(result: String) {
        Log.d("MVPFragment", "showResult")
        resultField.text = result
    }

    // display a toast message
    override fun showError(message: String) {
        Log.d("MVPFragment", "showError")
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    // clears input fields
    override fun clearInput() {
        Log.d("MVPFragment", "clearInput")
        inputField1.text.clear()
        inputField2.text.clear()
    }


}