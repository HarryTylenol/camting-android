buildscript {

  dependencies {
    project.apply { from("dependencies.gradle.kts") }
    val projectConfiguration: ProjectConfiguration by extra
    projectConfiguration.buildPlugins.dependencies.forEach { classpath(it) }
  }
  repositories {
    jcenter()
    mavenCentral()
    google()
    maven { url = uri("https://maven.fabric.io/public") }
  }
}

allprojects {
  repositories {
    jcenter()
    mavenCentral()
    google()
  }
}
