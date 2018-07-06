package app.chemistry.cache.di

import app.chemistry.cache.CamtingCacheDataSourceImp
import app.chemistry.data.data.CamtingCacheDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

  @Provides
  @Singleton
  fun provideCamtingCacheDataSource(): CamtingCacheDataSource = CamtingCacheDataSourceImp()

}