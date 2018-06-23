package app.chemistry.data.auth

import app.chemistry.data.toDomain
import app.chemistry.domain.auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(val authRequest: AuthRequest) : AuthRepository {

  override fun getAuthData() = authRequest.getAuthData().toDomain()

  override fun signOut() = authRequest.signOut()

  override fun isSignIn() = authRequest.isSignIn()

}