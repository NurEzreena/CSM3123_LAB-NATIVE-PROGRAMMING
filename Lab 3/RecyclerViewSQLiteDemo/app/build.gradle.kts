plugins {
    id("com.android.application") // Plugin for Android projects
    kotlin("android") // Kotlin plugin for Android
}

android {
    namespace = "com.example.recyclerviewsqlitedemo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.recyclerviewsqlitedemo"
        minSdk = 24 // Updated to allow support for more devices
        targetSdk = 34 // Set targetSdk to match compileSdk version
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
        sourceCompatibility = JavaVersion.VERSION_11 // Java 11 if needed
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11" // You can change to "1.8" if Java 8 compatibility is needed
    }
}

dependencies {
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation(libs.androidx.core.ktx) // Make sure the version is compatible with SDK 35
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
