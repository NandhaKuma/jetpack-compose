plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.8.20"
}

android {
    namespace = "com.task.jetpackcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.task.jetpackcompose"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.junit.ktx)

    androidTestImplementation(libs.androidx.espresso.core)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")



    implementation ("androidx.compose.ui:ui:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("androidx.activity:activity-compose:1.3.0")
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation (libs.logging.interceptor)
    implementation (libs.okhttp)
    implementation (libs.converter.scalars)

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1") // Check for the latest version
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1") // For LiveData support

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Ensure coroutines dependency is present

    implementation ("androidx.room:room-runtime:2.5.0" )// or the latest stable version
    kapt ("androidx.room:room-compiler:2.5.0") // or the latest stable version

    // Room KTX for coroutine support
    implementation ("androidx.room:room-ktx:2.5.0") // or the latest stable version


    //dagger
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    implementation ("androidx.paging:paging-compose:1.0.0-alpha18")
    implementation ("androidx.paging:paging-runtime:3.1.1")
}

kapt {
    correctErrorTypes = true
}