import org.gradle.internal.impldep.bsh.commands.dir
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig
import org.jetbrains.kotlin.gradle.dsl.Coroutines.ENABLE

plugins {
  id("com.android.library")
  kotlin("android")
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
    minSdkVersion(projectConfiguration.android.minSdkVersion)
    targetSdkVersion(projectConfiguration.android.targetSdkVersion)
    versionCode = projectConfiguration.android.versionCode
    versionName = projectConfiguration.android.versionName
    testInstrumentationRunner  = "android.support.test.runner.AndroidJUnitRunner"
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles("proguard-rules.pro")
    }
  }

}

dependencies {
  implementation(project(":data"))
  projectConfiguration.networkLibraries.dependencies.forEach { dependenciesImplements(it) }
}

kotlin {
  experimental {
    coroutines = ENABLE
  }
}
