package com.cs4520.assignment3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeFragment", "onCreateView")
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val mvpButton = view.findViewById<Button>(R.id.home_mvp_button)
        mvpButton.setOnClickListener {
            Log.d("HomeFragment", "MVP button clicked")
            // TODO: navigate to the MVP fragment
            findNavController().navigate(R.id.action_homeFragment_to_mvpFragment)
        }

        val mvvmButton = view.findViewById<Button>(R.id.home_mvvm_button)
        mvvmButton.setOnClickListener {
            Log.d("HomeFragment", "MVVM button clicked")
            findNavController().navigate(R.id.action_homeFragment_to_mvvmFragment)
        }
        return view
    }
}