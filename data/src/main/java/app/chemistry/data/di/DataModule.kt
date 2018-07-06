package app.chemistry.data.di

import app.chemistry.data.CamtingRepositoryImp
import app.chemistry.data.data.CamtingDataSourceFactory
import app.chemistry.data.query.CamtingRequestImp
import app.chemistry.domain.repository.CamtingRepository
import app.chemistry.domain.request.CamtingRequest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

  @Provides
  @Singleton
  fun provideCamtingRepository(
      camtingDataSourceFactory: CamtingDataSourceFactory): CamtingRepository =
      CamtingRepositoryImp(camtingDataSourceFactory)

  @Provides
  @Singleton
  fun provideCamtingRequest(): CamtingRequest = CamtingRequestImp()

}