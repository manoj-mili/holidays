apply (from = rootProject.file("base-build.gradle"))

plugins {
    id("com.android.library")
    id ("kotlin-android")
    id ("dagger.hilt.android.plugin")
}

addRetrofit()
addAndroidRoom()
addKotlinCoroutines()
addViewModel()
dependencies {
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:${Versions.roomVersion}")
}

