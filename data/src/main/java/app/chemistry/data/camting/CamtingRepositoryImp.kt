package app.chemistry.data.camting

import app.chemistry.data.toDomain
import app.chemistry.domain.camting.CamtingDomain
import app.chemistry.domain.camting.CamtingRepository
import io.reactivex.Single
import javax.inject.Inject

class CamtingRepositoryImp @Inject constructor(
    val camtingRequest: CamtingRequest
) : CamtingRepository {

  override fun getById(uid: String): Single<CamtingDomain> {
    return camtingRequest.getByUid(uid).map { it.toDomain() }
  }

}