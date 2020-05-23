package com.jjj.sample22.component

import com.jjj.sample22.MyApp
import com.jjj.sample22.model.Coffee
import com.jjj.sample22.module.ActivityBindingModule
import com.jjj.sample22.module.CoffeeModule
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

// Application 단위 클래스에 사용될 AppComponent : 최상위 Component
@Component(modules = [
        // AndroidInjectionModule::class,       // HasAndroidInjector, DispatchingAndroidInjector 직접 구현할 때 사용
        AndroidSupportInjectionModule::class,   // DaggerApplication, DaggerActivity로 HasAndroid,Dispatching 구현을 위임할 때 사용
        ActivityBindingModule::class,           // SubComponent.Factory 바인딩 목적의 Module
        CoffeeModule::class                     // Coffee 인스턴스 바인딩을 위한 Module
])
interface AppComponent : AndroidInjector<MyApp> {       // DaggerApplication 사용하려면 AndroidInjector<> 상속 필요

        fun coffees() : Map<Class<*>, Coffee>           // Coffee MultiBinding의 Provision 메서드
}