package com.afapartment.splashscreen.onboarding.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afapartment.splashscreen.R
import com.afapartment.splashscreen.databinding.FragmentThirdOnboardingBinding

class ThirdOnboardingFragment : Fragment() {

    private val binding = FragmentThirdOnboardingBinding.inflate(layoutInflater)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}