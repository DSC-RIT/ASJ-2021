package com.example.counterapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.counterapp.databinding.IntroFragmentBinding

class IntroFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: IntroFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.intro_fragment, container, false)

        binding.nextBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()

            val action = IntroFragmentDirections.actionIntroFragmentToCounterFragment(name)
            this.findNavController().navigate(action)
        }

        return binding.root
    }
}