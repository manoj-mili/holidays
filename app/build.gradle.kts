apply (from = rootProject.file("base-build.gradle"))
plugins {
    id("com.android.application")
    id("kotlin-android")
    id ("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        applicationId = ("com.mili.holidays")
    }
}

addRetrofit()
addJetPackNavigation()
dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation(project(mapOf("path" to ":core")))
    implementation(project(mapOf("path" to ":features:holidays")))
    implementation(project(mapOf("path" to ":features:countries")))
    testImplementation(Dependencies.junit)
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:${Versions.roomVersion}")
}