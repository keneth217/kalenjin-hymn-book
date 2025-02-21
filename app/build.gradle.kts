plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("kotlin-parcelize")
}

android {
    namespace = "com.keneth.hymnbook"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.keneth.hymnbook"
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

    implementation ("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.material:material:1.7.7")
    implementation ("androidx.graphics:graphics-shapes:1.0.1")
    implementation(libs.androidx.navigation.runtime.ktx)
//swipe to refresh

        implementation ("com.google.accompanist:accompanist-swiperefresh:0.36.0")// Check for the latest version
    


    val lifecycle_version = "2.8.7"
    val retrofit_version = "2.9.0"

    val nav_version = "2.8.7"

    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Jetpack Navigation Compose
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // ViewModel for Jetpack Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    // Retrofit & Gson Converter
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")


    //image loading
    implementation("io.coil-kt.coil3:coil-compose:3.1.0")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.1.0")
    //material icons
    implementation ("com.google.android.material:material:1.8.0")
//    implementation("androidx.compose.material3:material3:1.3.1")
//    implementation("androidx.compose.material3:material3-window-size-class:1.3.1")
//    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.4.0-alpha08")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}