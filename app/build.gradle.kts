plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    /** Remove comment if not needed **/
    //Google Service plugin
    //id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    kotlin("plugin.parcelize")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.lazydeveloper.initialprojectsetupcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lazydeveloper.initialprojectsetupcompose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug { isMinifyEnabled = false }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //Core
    implementation(libs.android.ktx)
    implementation(libs.android.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.splash)
    implementation(libs.androidx.datastore.preferences)

    //Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.espresso)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.compose.debug.manifest)

    //Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    //Timber
    implementation(libs.timber)
    /** Remove commented package if not needed **/
    //Firebase
//    implementation(platform(libs.firebase.bom))
//    implementation(libs.firebase.analytics)
//    implementation(libs.firebase.remote.config)

    //Google Play
//    implementation(libs.google.play.app.update)
//    implementation(libs.google.play.feature.delivery)
//    implementation(libs.google.play.app.update.ktx)

}


kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}