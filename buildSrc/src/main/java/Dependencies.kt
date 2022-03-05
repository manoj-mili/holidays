import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


const val implementation = "implementation"
const val api = "api"
const val testImplementation = "testImplementation"
const val kapt = "kapt"

/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

object Dependencies {

    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy { "junit:junit:${Versions.jUnit}" }

    val dagger2 by lazy {
        "com.google.dagger:dagger:${Versions.dagger2}"
    }
    val dagger2Kapt by lazy {
        "com.google.dagger:dagger-compiler:${Versions.dagger2}"
    }

    val retrofit2 by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit2}" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}" }
    val okhttpLogger by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}" }

    // moshi json library
    val moshi by lazy { "com.squareup.moshi:moshi:${Versions.moshi}" }
    val moshiRetrofitConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
    val moshiKapt by lazy { "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}" }
    val kotlinCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}" }
    val navFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}" }
    val navUI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }

    val recyclerView by lazy { "androidx.recyclerview:recyclerview:1.2.1" }
}

fun Project.addJetPackNavigation() {

    dependencies {
        // Kotlin
        add(implementation, Dependencies.navFragment)
        add(implementation, Dependencies.navUI)
    }
}

fun Project.addDagger() {
    dependencies {
        add(implementation, Dependencies.dagger2)
        add(kapt, Dependencies.dagger2Kapt)
    }
}

fun Project.addCoreUI() {
    dependencies {
        add(implementation, Dependencies.appCompat)
        add(implementation, Dependencies.constraintLayout)
        add(implementation, Dependencies.materialDesign)
        add(implementation, Dependencies.recyclerView)
    }
}

fun Project.addViewModel() {
    val lifecycleVersion = "2.5.0-alpha02"
    dependencies {
        // ViewModel
        api("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
        // LiveData
        api("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

        // Saved state module for ViewModel
        api("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion")

//        // Annotation processor
//        kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")
//        // alternately - if using Java8, use the following instead of lifecycle-compiler
//        implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")
    }
}

fun Project.addAndroidRoom() {
    dependencies {

        api("androidx.room:room-runtime:${Versions.roomVersion}")

        // optional - Kotlin Extensions and Coroutines support for Room
        api("androidx.room:room-ktx:${Versions.roomVersion}")

        // optional - Test helpers
        testImplementation("androidx.room:room-testing:${Versions.roomVersion}")

        // optional - Paging 3 Integration
        implementation("androidx.room:room-paging:${Versions.roomVersion}")
    }

}

fun Project.addRetrofit() {

    dependencies {
        add(api, Dependencies.retrofit2)
        add(api, Dependencies.okhttp)
        add(api, Dependencies.okhttpLogger)
        add(api, Dependencies.moshiRetrofitConverter)
        add(api, Dependencies.moshi)
    }
}

fun Project.addKotlinCoroutines() {
    dependencies {
        api(Dependencies.kotlinCoroutines)
        api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    }
}
