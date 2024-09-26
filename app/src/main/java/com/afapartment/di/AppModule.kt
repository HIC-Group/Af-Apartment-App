package com.afapartment.di

import com.afapartment.splashscreen.SplashViewModel
import com.afapartment.splashscreen.onboarding.OnBoardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val useCaseModule = module {

}

val viewModelModule = module {
    viewModelOf(::SplashViewModel)
    viewModelOf(::OnBoardingViewModel)
}