package app.chemistry.networking

import dagger.Module
import dagger.Provides

@Module
class NetworkingModule {

  @Provides
  fun provideFirebaseServiceFactory() = FirebaseNetworkingServiceFactory()

  @Provides
  fun provideCamtingRequestService(firebaseNetworkingServiceFactory: FirebaseNetworkingServiceFactory) = CamtingNetworkingService(firebaseNetworkingServiceFactory)

  @Provides
  fun provideAuthRequestService(firebaseNetworkingServiceFactory: FirebaseNetworkingServiceFactory) = AuthNetworkingService(firebaseNetworkingServiceFactory)

}