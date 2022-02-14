apply (from = rootProject.file("base-build.gradle"))

plugins {
    id("com.android.library")
    id ("kotlin-android")
}

addRetrofit()