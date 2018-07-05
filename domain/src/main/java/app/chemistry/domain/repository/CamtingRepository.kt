package app.chemistry.domain.repository

import app.chemistry.domain.model.CamtingDomain
import app.chemistry.domain.request.CamtingRequest
import app.chemistry.domain.request.RequestType

interface CamtingRepository {

  suspend fun getCamtingByUser(uid: String): CamtingDomain?
  suspend fun getCamtingById(id: String): CamtingDomain?

  suspend fun requestCamtings(request: CamtingRequest): List<CamtingDomain>

  suspend fun addCamting(camtingDomain: CamtingDomain)

}