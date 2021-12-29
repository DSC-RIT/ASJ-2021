package com.example.counterapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.counterapp.databinding.CounterFragmentBinding

class CounterFragment: Fragment() {
    private val counterViewModel: CounterViewModel by viewModels()
    private lateinit var binding: CounterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = DataBindingUtil.inflate(
            inflater, R.layout.counter_fragment, container, false)

        return binding.root
//        return inflater.inflate(R.layout.counter_fragment, container, false).rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameTextView = binding.nameTv
        val counterTextView = binding.counterTv
        val counterButton = binding.counterBtn

        val name = arguments?.getString("name").toString().trim()
        nameTextView.text = "Hi, $name!"

        counterButton.setOnClickListener {
            counterViewModel.increaseCounter()
        }

        counterViewModel.counter.observe(viewLifecycleOwner) { newCounter ->
            counterTextView.text = newCounter.toString()
        }
//        val nameTextView = view.findViewById<TextView>(R.id.name_tv)
//        val counterTextView = view.findViewById<TextView>(R.id.counter_tv)
//        val counterButton = view.findViewById<Button>(R.id.counter_btn)
//        var counter = 0
//
//        val name = arguments?.getString("name").toString().trim()
//        nameTextView.text = "Hi, $name!"
//
//        counterButton.setOnClickListener {
//            counter++
//            counterTextView.text = counter.toString()
//        }
    }
}