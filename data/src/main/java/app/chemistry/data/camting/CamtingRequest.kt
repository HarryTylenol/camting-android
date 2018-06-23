package app.chemistry.data.camting

import app.chemistry.data.model.CamtingData
import io.reactivex.Observable
import io.reactivex.Single

interface CamtingRequest {

  fun getByUid(uid : String): Single<CamtingData>

  fun getImages(camtingData: CamtingData) :  Observable<String>

  fun isCached(uid : String) : Boolean

}