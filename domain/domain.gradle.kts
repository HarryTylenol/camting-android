import org.jetbrains.kotlin.gradle.dsl.Coroutines.ENABLE

plugins {
  id("kotlin")
  kotlin("kapt")
}

project.apply { from("../dependencies.gradle.kts") }
val projectConfiguration: ProjectConfiguration by extra
var dependenciesImplements: Project.(Pair<Int, String>) -> Unit by extra

configurations.all {
  resolutionStrategy {
    force("org.jetbrains.kotlin:kotlin-stdlib:1.2.50")
  }

}

dependencies {
  projectConfiguration.domainLibraries.dependencies.forEach { dependenciesImplements(it) }
}

kotlin {
  experimental {
    coroutines = ENABLE
  }
}
