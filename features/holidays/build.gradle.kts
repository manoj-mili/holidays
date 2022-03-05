apply (from = rootProject.file("base-build.gradle"))
plugins {
    id("com.android.library")
    id("kotlin-android")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
}

addCoreUI()
addJetPackNavigation()
dependencies {
    implementation(project(mapOf("path" to ":core")))
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:${Versions.roomVersion}")
    implementation("io.coil-kt:coil:1.4.0")
    add(kapt, Dependencies.moshiKapt)
}