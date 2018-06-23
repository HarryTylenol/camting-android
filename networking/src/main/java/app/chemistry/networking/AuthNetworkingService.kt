package app.chemistry.networking

import app.chemistry.data.model.AuthData
import app.chemistry.data.auth.AuthRequest

class AuthNetworkingService(val firebaseNetworkingServiceFactory: FirebaseNetworkingServiceFactory) : AuthRequest {

  override fun getAuthData(): AuthData {
    val auth = firebaseNetworkingServiceFactory.provideAuth()
    return AuthData(uid = auth.uid, phoneNumber = auth.currentUser?.phoneNumber)
  }

  override fun signOut() {
    firebaseNetworkingServiceFactory.provideAuth().signOut()
  }

  override fun isSignIn() = firebaseNetworkingServiceFactory.provideAuth().currentUser != null

}