package com.afapartment.splashscreen.onboarding.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afapartment.splashscreen.databinding.FragmentFirstOnboardingBinding

class FirstOnboardingFragment : Fragment() {

    private val binding = FragmentFirstOnboardingBinding.inflate(layoutInflater)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}