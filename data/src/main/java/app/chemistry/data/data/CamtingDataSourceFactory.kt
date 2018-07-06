package app.chemistry.data.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CamtingDataSourceFactory @Inject constructor(
    private val camtingCacheRepository: CamtingCacheDataSource,
    private val camtingSnapshotRepository: CamtingSnapshotDataSource
) {

  fun provideRepository(id: String): CamtingDataSource {
    if (camtingCacheRepository.isCamtingCached(id)) {
      return camtingCacheRepository
    }
    return camtingSnapshotRepository
  }

  fun provideCacheRepository() = camtingCacheRepository
  fun provideSnapshotRepository() = camtingSnapshotRepository

}