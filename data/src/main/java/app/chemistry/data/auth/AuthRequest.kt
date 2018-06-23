package app.chemistry.data.auth

import app.chemistry.data.model.AuthData

interface AuthRequest {

  fun getAuthData(): AuthData
  fun signOut()

  fun isSignIn(): Boolean

}