package com.udacity.shoestore.WelcomeScreenFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding


class WelcomeScreenFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_welcome_screen,container,false)

        binding.welcomeGoButton.setOnClickListener{
            val action=WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionsFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }


        return binding.root
    }


}