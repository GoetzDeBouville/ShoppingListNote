plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    id("org.jetbrains.kotlin.kapt")
    alias(libs.plugins.hilt)
    id("kotlin-parcelize")
}

android {
    namespace = "com.goetzgegouville.myapplication"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.goetzgegouville.myapplication"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    // DI Hilt
    implementation(libs.hilt.android)
    debugImplementation(libs.androidx.ui.tooling)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.androidx)
    kapt(libs.hilt.androidx.compiler)

    // Datastore
    implementation(libs.datastore)

    // Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation)

    // DB Room
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.compose.viewmodel)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material)
    implementation(libs.compose.material3.alpha)
    implementation(libs.constraintlayout)
    implementation(libs.bundles.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.test.manifest)
}