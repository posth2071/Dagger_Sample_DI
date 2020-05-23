package com.jjj.sample22.module

import com.jjj.sample22.component.ActivityScope
import com.jjj.sample22.model.Americano
import com.jjj.sample22.model.Coffee
import com.jjj.sample22.model.Espresso
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds

@Module
abstract class CoffeeModule {

    // @ActivityScope   // Component와 같이 Scope 설정 : MainActivity는 앱종료 전까지 항상 동일한 인스턴스 반환 -> Provider 소용 X, 그러므로 주석처리
    @Binds
    @IntoMap    // MultiBinding을 위해 @IntoMap 설정 : Map 컬렉션으로 바인딩
    @ClassKey(Espresso::class)  // Map 컬렉션의 Key 설정 annotation
    abstract fun bindEspresso(espresso: Espresso): Coffee   // Espresso 인스턴스를 Coffee 타입으로 바인딩해서 반환, Map 컬렉션의 Value 부분

    // @ActivityScope
    @Binds
    @IntoMap
    @ClassKey(Americano::class)
    abstract fun bindAmericano(americano: Americano): Coffee    // Americano 인스턴스를 Coffee 타입으로 바인딩해서 반환
}