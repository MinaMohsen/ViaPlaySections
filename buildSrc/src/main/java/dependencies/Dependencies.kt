package dependencies

object Dependencies {

    val supportAndroidLibs = arrayOf(
        "androidx.annotation:annotation:${Versions.SupportAndroidLibs.supportLibrary}",
        "androidx.appcompat:appcompat:${Versions.SupportAndroidLibs.supportLibrary}",
        "androidx.cardview:cardview:${Versions.SupportAndroidLibs.supportLibrary}",
        "androidx.recyclerview:recyclerview:${Versions.SupportAndroidLibs.supportLibrary}",
        "com.google.android.material:material:${Versions.SupportAndroidLibs.materialDesignLibrary}",
        "androidx.multidex:multidex:${Versions.SupportAndroidLibs.multiDex}",
        "androidx.constraintlayout:constraintlayout:${Versions.SupportAndroidLibs.constraintLayout}"
    )

    val androidArchComponents = arrayOf(
        "androidx.lifecycle:lifecycle-runtime:${Versions.SupportAndroidLibs.androidArcComponents}",
        "androidx.lifecycle:lifecycle-extensions:${Versions.SupportAndroidLibs.androidArcComponents}",
        "androidx.lifecycle:lifecycle-reactivestreams:${Versions.SupportAndroidLibs.androidArcComponents}",
        "androidx.room:room-runtime:${Versions.SupportAndroidLibs.roomLibrary}",
        "androidx.room:room-rxjava2:${Versions.SupportAndroidLibs.roomLibrary}"
    )

    val kotlin = arrayOf(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.std}"
    )


    val libraries = arrayOf(
        // RxJava, RxAndroid
        "io.reactivex.rxjava2:rxandroid:${Versions.Libraries.rxAndroid}",
        "io.reactivex.rxjava2:rxjava:${Versions.Libraries.rxJava}",

        // OkHttp and Retrofit
        "com.squareup.okhttp3:okhttp:${Versions.Libraries.okHttp}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Libraries.okHttp}",
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.Libraries.okHttp}",
        "com.squareup.retrofit2:retrofit:${Versions.Libraries.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Versions.Libraries.retrofit}",
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.Libraries.retrofit}",
        "com.squareup.retrofit2:retrofit-mock:${Versions.Libraries.retrofit}",

        // Gson
        "com.squareup.retrofit2:converter-gson:${Versions.Libraries.retrofit}"
    )

    val annotations = arrayOf(
        // Android Architecture Components
        "androidx.lifecycle:lifecycle-compiler:${Versions.SupportAndroidLibs.androidArcComponents}",

        // Room
        "androidx.room:room-compiler:${Versions.SupportAndroidLibs.androidArcComponents}"
    )
}