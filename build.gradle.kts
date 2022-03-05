// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.1")
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}