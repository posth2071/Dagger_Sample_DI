package com.jjj.sample22.component

import com.jjj.sample22.MainActivity
import com.jjj.sample22.MyApp
import com.jjj.sample22.model.Coffee
import com.jjj.sample22.module.ActivityBindingModule
import com.jjj.sample22.module.CoffeeModule
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

//@ActivityScope    // Provider<> 확인을 위해 Scope 제거
@Subcomponent(modules = [])
interface MainComponent : AndroidInjector<MainActivity> {   // AndroidInjector<Activity이름> 상속 필요 : DispatchingAndroidInjector 사용위함

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity> {}
}
// 이렇게 빈 Component는 @ContributesAndroidInjector로 대체 구현가능