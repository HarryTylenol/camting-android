import Dependencies_gradle.Config.ANDROID_TEST_IMP
import Dependencies_gradle.Config.ANDROID_TEST_KAPT
import Dependencies_gradle.Config.DEBUG_IMP
import Dependencies_gradle.Config.IMP
import Dependencies_gradle.Config.KAPT
import Dependencies_gradle.Config.RELEASE_IMP
import Dependencies_gradle.Config.TEST_IMP
import Dependencies_gradle.Config.TEST_KAPT
import Dependencies_gradle.Versions.androidx_version
import Dependencies_gradle.Versions.applicationId
import Dependencies_gradle.Versions.compileSdkVersion
import Dependencies_gradle.Versions.kotlin_version
import Dependencies_gradle.Versions.minSdkVersion
import Dependencies_gradle.Versions.targetSdkVersion
import Dependencies_gradle.Versions.versionCode
import Dependencies_gradle.Versions.versionName

var projectConfiguration: ProjectConfiguration by extra
var commonConfiguration: Project.() -> Unit by extra
var dependenciesImplements: Project.(Pair<Int, String>) -> Unit by extra

object Versions {
  const val versionCode = 1
  const val versionName = "1.0"
  const val compileSdkVersion = 28
  const val applicationId = "app.chemistry.camting"
  const val minSdkVersion = 21
  const val targetSdkVersion = 28
  const val kotlin_version = "1.2.50"
  const val androidGradleVersion = "3.2.0-beta01"
  const val androidx_version = "1.0.0-alpha3"
}

object Config {
  const val IMP = 0
  const val KAPT = 1
  const val TEST_KAPT = 2
  const val TEST_IMP = 3
  const val ANDROID_TEST_IMP = 4
  const val ANDROID_TEST_KAPT = 5
  const val DEBUG_IMP = 6
  const val RELEASE_IMP = 7
}

object Test {
  const private val mockito_version = "1.10.19"
  const private val espresso_version = "3.1.0-alpha1"

  const val junit = "junit:junit:4.12"
  const val kotlin_junit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version"
  const val espresso = "androidx.test.espresso:espresso-core:$espresso_version"
  const val android_test_runner = "androidx.test:runner:$androidx_version"
  const val mockito = "org.mockito:mockito-core:$mockito_version"
  const val mockito_kotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0-RC1"
}

object Rx {
  const private val rx_java_version = "2.1.14"
  const private val rx_kotlin_version = "2.2.0"
  const private val rx_android_version = "2.0.2"

  const val rxjava = "io.reactivex.rxjava2:rxjava:$rx_java_version"
  const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:$rx_kotlin_version"
  const val rxandroid = "io.reactivex.rxjava2:rxandroid:$rx_android_version"
  const val rxbinding = "com.jakewharton.rxbinding2:rxbinding:2.1.1"
}

object Kotlin {
  const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
  const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:0.22.5"
}

object Misc {
  const private val leakcanary_version = "1.5.4"
  const private val glide_version = "4.7.1"

  const val retrofit_extensions = "ru.gildor.coroutines:kotlin-coroutines-retrofit:0.10.0"
  const val glide = "com.github.bumptech.glide:glide:$glide_version"
  const val fishbun = "com.sangcomz:FishBun:0.8.6"
  const val photoview = "com.github.devahamed:multi-view-adapter:1.2.3"
  const val multi_adapter = "com.github.devahamed:multi-view-adapter:1.2.3"
  const val realm_extensions = "com.github.vicpinm:krealmextensions:2.2.0"
  const val leakcanary = "com.squareup.leakcanary:leakcanary-android:$leakcanary_version"
  const val leakcanary_no_op = "com.squareup.leakcanary:leakcanary-android-no-op:$leakcanary_version"
  const val facebook_login = "com.facebook.android:facebook-android-sdk:[4,5)"
}

object Anko {
  const private val anko_version = "0.10.5"

  const val anko_commons = "org.jetbrains.anko:anko-commons:$anko_version"
  const val anko_sdk25 = "org.jetbrains.anko:anko-sdk25:$anko_version"
}

object Dagger {
  const private val dagger_version = "2.16"

  const val dagger = "com.google.dagger:dagger:$dagger_version"
  const val javax_annotation = "org.glassfish:javax.annotation:10.0-b28"
  const val dagger_compiler = "com.google.dagger:dagger-compiler:$dagger_version"
  const val dagger_android = "com.google.dagger:dagger-android:$dagger_version"
  const val dagger_android_support = "com.google.dagger:dagger-android-support:$dagger_version"
  const val dagger_android_processor = "com.google.dagger:dagger-android-processor:$dagger_version"
}

object Retrofit {
  const private val retrofit_version = "2.4.0"

  const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
  const val retrofit_gson = "com.squareup.retrofit2:converter-gson:$retrofit_version"
}

object AndroidX {
  const private val material_component_version = "1.0.0-alpha1"
  const private val ktx_version = "1.0.0-alpha1"
  const private val lifecycle_version = "2.0.0-alpha1"

  const val appcompat = "androidx.appcompat:appcompat:$androidx_version"
  const val fragment = "androidx.fragment:fragment:$androidx_version"
  const val recyclerview = "androidx.recyclerview:recyclerview:$androidx_version"
  const val lifecycle = "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
  const val cardview = "androidx.cardview:cardview:$androidx_version"
  const val material_component = "com.google.android.material:material:$material_component_version"
}

object Firebase {
  const val core_version = "16.0.1"
  const val firestore_version = "17.0.2"
  const val storage_version = "16.0.1"
  const val auth_version = "16.0.2"
  const val messaging_version = "17.0.0"
  const val perf_version = "16.0.0"
  const val config_version = "16.0.1"
  const val crashlytics_version = "2.9.3"

  const val firebase_core = "com.google.firebase:firebase-core:$core_version"
  const val firebase_firestore = "com.google.firebase:firebase-firestore:$firestore_version"
  const val firebase_storage = "com.google.firebase:firebase-storage:$storage_version"
  const val firebase_auth = "com.google.firebase:firebase-auth:$auth_version"
  const val firebase_messaging = "com.google.firebase:firebase-messaging:$messaging_version"
  const val firebase_perf = "com.google.firebase:firebase-perf:$perf_version"
  const val firebase_config = "com.google.firebase:firebase-config:$config_version"
  const val firebase_crashlytics = "com.crashlytics.sdk.android:crashlytics:$crashlytics_version"
}

object GradlePlugins {
  const private val android_tools_version = "3.2.0-beta01"
  const private val realm_version = "5.3.0"
  const private val fabric_version = "1.25.4"
  const private val google_services_version = "3.2.1"
  const private val firebase_version = "1.1.5"

  const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
  const val android_tools = "com.android.tools.build:gradle:3.2.0-beta01"
  const val google_services = "com.google.gms:google-services:$google_services_version"
  const val firebase = "com.google.firebase:firebase-plugins:$firebase_version"
  const val fabric = "io.fabric.tools:gradle:$fabric_version"
  const val realm = "io.realm:realm-gradle-plugin:$realm_version"
}

object Realm {
  const val extensions = "com.github.vicpinm:krealmextensions:2.2.0"
}

val gradlePlugins = arrayOf(
    GradlePlugins.android_tools,
    GradlePlugins.fabric,
    GradlePlugins.firebase,
    GradlePlugins.google_services,
    GradlePlugins.kotlin,
    GradlePlugins.realm
)

val androidLib = arrayOf(
    IMP to Dagger.dagger_android,
    IMP to Dagger.dagger_android_support,
    KAPT to Dagger.dagger_android_processor,
    ANDROID_TEST_KAPT to Dagger.dagger_compiler,
    ANDROID_TEST_IMP to Test.espresso,
    ANDROID_TEST_IMP to Test.android_test_runner,
    ANDROID_TEST_IMP to Test.mockito,
    ANDROID_TEST_IMP to Test.mockito_kotlin,
    ANDROID_TEST_IMP to Test.kotlin_junit,
    ANDROID_TEST_IMP to Test.junit
)
val commonLib = arrayOf(
    IMP to Rx.rxjava,
    IMP to Rx.rxkotlin,
    IMP to Kotlin.kotlin,
    IMP to Kotlin.coroutines,
    IMP to Dagger.dagger,
    IMP to Dagger.javax_annotation,
    KAPT to Dagger.dagger_compiler,
    TEST_KAPT to Dagger.dagger_compiler,
    TEST_IMP to Test.mockito,
    TEST_IMP to Test.mockito_kotlin,
    TEST_IMP to Test.kotlin_junit,
    TEST_IMP to Test.junit
)
val appLibraries = arrayOf(
    IMP to Rx.rxandroid,
    IMP to Rx.rxbinding,

    IMP to Firebase.firebase_core,
    IMP to Anko.anko_commons,
    IMP to Anko.anko_sdk25,

    IMP to AndroidX.appcompat,
    IMP to AndroidX.fragment,
    IMP to AndroidX.cardview,
    IMP to AndroidX.lifecycle,
    IMP to AndroidX.material_component,

    *commonLib,
    *androidLib
)
val domainLibraries = arrayOf(*commonLib)
val dataLibraries = arrayOf(
    IMP to Firebase.firebase_firestore,
    IMP to Dagger.dagger_android,
    IMP to Dagger.dagger_android_support,
    KAPT to Dagger.dagger_android_processor,
    *commonLib,
    *androidLib)
val networkLibraries = arrayOf(
    IMP to Firebase.firebase_firestore,
    IMP to Firebase.firebase_storage,
    IMP to Firebase.firebase_auth,
    IMP to Retrofit.retrofit,
    IMP to Retrofit.retrofit_gson,
    IMP to Misc.retrofit_extensions,
    *commonLib,
    *androidLib
)
val cacheLibraries = arrayOf(
    IMP to Misc.realm_extensions,
    *commonLib,
    *androidLib
)

projectConfiguration = ProjectConfiguration(
    JavaVersion.VERSION_1_8,
    Android(versionCode, versionName, applicationId, minSdkVersion, targetSdkVersion,
            compileSdkVersion),
    BuildPlugins(*gradlePlugins),
    CommonLibraries(*commonLib),
    AppLibraries(*appLibraries),
    DomainLibraries(*domainLibraries),
    DataLibraries(*dataLibraries),
    NetworkLibraries(*networkLibraries),
    CacheLibraries(*cacheLibraries)
)

dependenciesImplements = { deps ->
  val config = when (deps.first) {
    IMP               -> "implementation"
    KAPT              -> "kapt"
    TEST_IMP          -> "testImplementation"
    TEST_KAPT         -> "kaptTest"
    ANDROID_TEST_IMP  -> "androidTestImplementation"
    ANDROID_TEST_KAPT -> "kaptAndroidTest"
    RELEASE_IMP       -> "releaseImplementation"
    DEBUG_IMP         -> "debugImplementation"
    else              -> "implementation"
  }
  //  this.dependencies.add()
  this.dependencies.add(config, deps.second)
}

commonConfiguration = {

}