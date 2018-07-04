package app.chemistry.network.di

import app.chemistry.data.CamtingSnapshotRepository
import app.chemistry.network.util.FirestoreReference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

  @Provides
  @Singleton
  internal fun provideFirestoreReferenceRepository() = FirestoreReference()

  @Provides
  @Singleton
  internal fun provideCamtingSnapshotRepository(frr: FirestoreReference): CamtingSnapshotRepository = CamtingSnapshotRepositoryImp(frr)

}