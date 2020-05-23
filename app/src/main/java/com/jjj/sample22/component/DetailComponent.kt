package com.jjj.sample22.component

import com.jjj.sample22.DetailActivity
import com.jjj.sample22.MainActivity
import com.jjj.sample22.MyApp
import com.jjj.sample22.module.ActivityBindingModule
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Subcomponent(modules = [])
interface DetailComponent : AndroidInjector<DetailActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<DetailActivity> {}
}