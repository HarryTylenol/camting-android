package app.chemistry.domain.camting

import io.reactivex.Single

interface CamtingRepository {

  fun getById(uid: String): Single<CamtingDomain>

}