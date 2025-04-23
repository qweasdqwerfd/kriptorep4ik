plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.example.kriptorep4ik"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.kriptorep4ik"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }



}

dependencies {
    implementation("org.jsoup:jsoup:1.15.3")
    implementation("io.coil-kt.coil3:coil-compose:3.1.0") // для icon
    implementation ("com.google.accompanist:accompanist-pager:0.28.0") // Проверьте актуальную версию
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.28.0") // Для индикаторов
    implementation("com.github.PhilJay:MPAndroidChart:3.1.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.19.1")
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.34.0")

    implementation("io.ktor:ktor-client-core:2.3.7")
    implementation("io.ktor:ktor-client-cio:2.3.7")     // Для JVM/Android
    implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation(libs.kotlinx.serialization.json)
    implementation ("androidx.core:core-splashscreen:1.0.1") // или последняя
    implementation ("com.google.android.material:material:1.11.0") // актуальная
    implementation ("androidx.activity:activity:1.9.0")



    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation ("androidx.compose.ui:ui:1.6.0")
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.android)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.material)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.media3.common.ktx)
    implementation(libs.transport.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}