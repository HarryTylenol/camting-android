package app.chemistry.domain.auth

interface AuthRepository {

  fun getAuthData(): AuthDomain
  fun signOut()
  fun isSignIn() : Boolean

}