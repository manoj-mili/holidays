plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    compileOnly(gradleApi())
    implementation ("com.android.tools.build:gradle:7.0.4")
    implementation ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
    implementation(kotlin("stdlib-jdk8"))
}
