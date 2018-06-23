class ProjectConfiguration(
    val android: Android,
    val buildPlugins: BuildPlugins,
    val commonLibraries: CommonLibraries,
    val appLibraries: AppLibraries,
    val domainLibraries: DomainLibraries,
    val dataLibraries: DataLibraries,
    val networkLibraries : NetworkLibraries,
    val cacheLibraries: CacheLibraries
)

class Android(
    val versionCode: Int,
    val versionName: String,
    val applicationId: String,
    val minSdkVersion: Int,
    val targetSdkVersion: Int,
    val compileSdkVersion: Int
)

class BuildPlugins(
    vararg val dependencies: String
)

class CommonLibraries(
    vararg val dependencies: Pair<Int, String>
)

class AppLibraries(
    vararg val dependencies: Pair<Int, String>
)

class DomainLibraries(
    vararg val dependencies: Pair<Int, String>
)

class DataLibraries(
    vararg val dependencies: Pair<Int, String>
)

class NetworkLibraries(
    vararg val dependencies: Pair<Int, String>
)

class CacheLibraries(
    vararg val dependencies: Pair<Int, String>
)
