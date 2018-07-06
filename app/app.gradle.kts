import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig
import org.jetbrains.kotlin.gradle.dsl.Coroutines.ENABLE

plugins {
  id("com.android.application")
  kotlin("android")
  id("io.fabric")
  kotlin("kapt")
}

project.apply { from("../dependencies.gradle.kts") }
val projectConfiguration: ProjectConfiguration by extra
var dependenciesImplements: Project.(Pair<Int, String>) -> Unit by extra

android {

  lintOptions { warning("InvalidPackage") }
  compileOptions {
    setSourceCompatibility(projectConfiguration.javaVersion)
    setTargetCompatibility(projectConfiguration.javaVersion)
  }

  compileSdkVersion(projectConfiguration.android.compileSdkVersion)
  defaultConfig {
    applicationId = projectConfiguration.android.applicationId
    minSdkVersion(projectConfiguration.android.minSdkVersion)
    targetSdkVersion(projectConfiguration.android.targetSdkVersion)
    versionCode = projectConfiguration.android.versionCode
    versionName = projectConfiguration.android.versionName
//    testInstrumentationRunner = "app.chemistry.camting.TestRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles("proguard-rules.pro")
    }
  }

}

repositories {
  maven { url = uri("https://oss.jfrog.org/artifactory/oss-snapshot-local") }
}

dependencies {
  implementation(project(":cache"))
  implementation(project(":data"))
  implementation(project(":network"))
  implementation(project(":domain"))

  projectConfiguration.appLibraries.dependencies.forEach { dependenciesImplements(it) }
}

kotlin {
  experimental {
    coroutines = ENABLE
  }
}

apply {
  plugin("com.google.gms.google-services")
}

