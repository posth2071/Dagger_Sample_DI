package com.jjj.sample22

import android.app.Activity
import android.app.Application
import com.jjj.sample22.component.AppComponent
import com.jjj.sample22.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/* dagger.android의 DaggerApplication() 사용
 *  : Application(), HasAndroidInjector() 상속한 클래스
 *    Dagger 의존성주입 위임 -> androidInjector(), DispatchingAndroidInjector
 *    Application 클래스의 onCreate() 위임
 */
class MyApp : DaggerApplication() {
    /**
     * Implementations should return an [AndroidInjector] for the concrete [ ]. Typically, that injector is a [dagger.Component].
     */
    // DaggerApplication의 구현메서드 (재정의)

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.create()  // AppComponent 인스턴스를 반환
        // 반환Type 충족(AndroidInjecotr<out DaggerApplication>) : AppComponent 선언 시 AndroidInjecotr<MyApp> 상속
    }



    override fun onCreate() {
        super.onCreate()
//        DaggerAppComponent.create().inject(this@MyApp)
    }

    /** HasAndroidInjector를 직접 구현하는 방식
     *      1. MyApp의 HasAndroidInjector() 상속
     *      2. DispatchingAndroidInjector<Any> 의존성 주입
     *      3. HasAndroidInjector의 구현메서드 재정의 : androidInjector()
     */
//    @Inject
//    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

//    /** Returns an [AndroidInjector].  */
//    override fun androidInjector(): AndroidInjector<Any>? {
//        return dispatchingAndroidInjector
//    }
}