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
  compileSdkVersion(projectConfiguration.android.compileSdkVersion)

  lintOptions { warning("InvalidPackage") }
  compileOptions {
    setSourceCompatibility(projectConfiguration.javaVersion)
    setTargetCompatibility(projectConfiguration.javaVersion)
  }

  defaultConfig {
    minSdkVersion(projectConfiguration.android.minSdkVersion)
    targetSdkVersion(projectConfiguration.android.targetSdkVersion)
    versionCode = projectConfiguration.android.versionCode
    versionName = projectConfiguration.android.versionName
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles("proguard-rules.pro")
    }
  }

}

dependencies {
  implementation(project(":domain"))
  projectConfiguration.dataLibraries.dependencies.forEach { dependenciesImplements(it) }
  compileOnly("javax.annotation:jsr250-api:1.0")
}

kotlin {
  experimental {
    coroutines = ENABLE
  }
}
