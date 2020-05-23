package com.jjj.sample22.model

import javax.inject.Inject

// Coffee 인터페이스 구현체 Americano 클래스
class Americano @Inject constructor() : Coffee {    // @Inject 생성자, @Binds 메서드에 Americano 인스턴스 제공을 위해 선언
    override fun name(): String = "Americano"
}