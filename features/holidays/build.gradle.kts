apply (from = rootProject.file("base-build.gradle"))
plugins {
    id("com.android.library")
    id("kotlin-android")
}

addCoreUI()
addJetPackNavigation()
addRetrofit()

dependencies {

    implementation(project(mapOf("path" to ":core")))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
}