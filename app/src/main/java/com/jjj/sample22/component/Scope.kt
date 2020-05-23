package com.jjj.sample22.component

import javax.inject.Scope


// Kotlin Custome Scope 설정
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope {}

// JAVA Custome Scope 설정
// @Scope
// @Retention(AnnotationRetention.RUNTIME)
// public @interface ActivityScope {}