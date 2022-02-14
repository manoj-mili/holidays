apply (from = rootProject.file("base-build.gradle"))
plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    defaultConfig {
        applicationId = ("com.mili.holidays")
    }
}

addRetrofit()
dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation(Dependencies.appCompat)
    implementation(Dependencies.materialDesign)
    implementation(Dependencies.constraintLayout)
    implementation(project(mapOf("path" to ":core")))
    implementation(project(mapOf("path" to ":features:holidays")))
    testImplementation(Dependencies.junit)
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}