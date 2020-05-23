package com.jjj.sample22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jjj.sample22.model.Americano
import com.jjj.sample22.model.Coffee
import com.jjj.sample22.model.Espresso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Provider

class DetailActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName

    var espresso : Coffee? = null
    var americano : Coffee? = null

    /* @JvmSuppressWildcards : 코틀린 제네릭 자동변환을 하지않는 Kotlin Annotation
    *       Map<Class<*>, Coffee> -> Map<Class<*>, <? extends Coffee> 자동변환을 막도록 설정
    *  Provider<> : get() 요청마다 새로운 인스턴스를 반환
    */
    @Inject
    lateinit var coffee: Map<Class<*>, @JvmSuppressWildcards Provider<Coffee>>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this@DetailActivity)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Provider, 객체가 매번 새로 할당되는지 확인을 위해 5번 반복
        repeat(5) {
            Log.d(TAG, "Order Count - $it")
            // Provider<Coffee> 타입 : get()으로 Coffee 인스턴스 반환
            espresso = coffee[Espresso::class.java]?.get()
            Log.d(TAG, "${espresso?.name()} Coffee - ${espresso.hashCode()}")   // 전과 동일한 인스턴스인지 확인 : hashCode()

            americano = coffee[Americano::class.java]?.get()
            Log.d(TAG, "${americano?.name()} Coffee - ${americano.hashCode()}")
        }

        button.setOnClickListener {
            finish()
        }
    }
}
