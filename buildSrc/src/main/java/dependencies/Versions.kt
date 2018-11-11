package dependencies

object Versions {

    // Version Name
    val versionName = "1.0"
    val versionCode = 1

    object SupportAndroidLibs {
        const val gradlePlugin = "3.2.1"
        const val compileSdk = 28
        const val minSdk = 21
        const val targetSdk = 28
        const val supportLibrary = "1.0.0"
        const val materialDesignLibrary = "1.0.0-rc01"
        const val constraintLayout = "1.1.2"
        const val androidArcComponents = "2.0.0-rc01"
        const val roomLibrary = "2.1.0-alpha01"
        const val multiDex = "2.0.0"
    }

    object Kotlin {
        const val std = "1.3.0"
    }

    object Libraries {
        // RxJava and RxAndroid
        const val rxAndroid = "2.0.1"
        const val rxJava = "2.1.9"

        // OkHttp and Retrofit
        const val retrofit = "2.3.0"
        const val okHttp = "3.9.1"

        // Gson
        const val gson = "2.8.2"

        //Dagger 2
        const val dagger = "2.15"

        //Java annotations
        const val javaAnnotation = "1.0"
    }
}