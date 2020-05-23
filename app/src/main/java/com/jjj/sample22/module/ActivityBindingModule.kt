package com.jjj.sample22.module

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.jjj.sample22.DetailActivity
import com.jjj.sample22.MainActivity
import com.jjj.sample22.component.ActivityScope
import com.jjj.sample22.component.DetailComponent
import com.jjj.sample22.component.MainComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

// AppComponent의 하위Component인 Main/Detail Component 설정 (상하 관계 설정) : @ContributesAndroidInjector 사용 시 생략
@Module(subcomponents = [MainComponent::class, DetailComponent::class])
abstract class ActivityBindingModule {

    /** SubComponent는 코드가 부모 Component 내부에 선언되어 사용
     *  SubComponent는 generate(자동생성) X : Factory 또는 Builder를 부모에 선언해줘야 부모Component에 자동 generate 됨
     *  Factory, Builder를 MultiBinding으로 바인딩해서 부모 Component에 전달
     *      : SubComponent.Factory -> AndroidInjector.Factory 타입으로 바인딩 (SubComponent가 AndroidInjector.Factory를 상속 필요)
     */
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)  // MultiBinding, Map 컬렉션의 Key Type
    abstract fun bindMainComponentFactory(factory: MainComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(DetailActivity::class)
    abstract fun bindDetailComponentFactory(factory: DetailComponent.Factory): AndroidInjector.Factory<*>

    /** SubComponent와 SubComponent.Factory 내부 메서드 X, 부모 X 경우
     *  즉, 내용이 없는 경우엔 @ContributesAndroidInjector 애노테이션으로 SubComponent 인터페이스 선언을 대체해서 사용
     *      : SubComponent 인터페이스 생성하지 않아도 SubComponent 구현을 가능하게 함
     *        modules, @Scope 설정 모두 동일하게 가능
     */
//    @ContributesAndroidInjector(modules = [...])
//    abstract fun mainActivity() : MainActivity
//
//    @ContributesAndroidInjector(modules = [...])
//    abstract fun detailActivity() : DetailActivity
}