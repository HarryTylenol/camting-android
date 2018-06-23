package app.chemistry.cache

import app.chemistry.data.executor.CamtingCaching
import app.chemistry.data.model.CamtingData
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe

class CamtingCachingService : CamtingCaching {

  private val cachedCamting = hashMapOf<String, CamtingData>()
  private val cachedCamtingImages = hashMapOf<String, List<String>>()

  override fun getByUid(uid: String) = Single.create(SingleOnSubscribe<CamtingData> {
    val data = cachedCamting[uid]
    if (data != null) it.onSuccess(data)
    else it.onError(Exception("Not Cached"))
  })

  override fun getImages(camtingData: CamtingData) = Observable.create(ObservableOnSubscribe<String> {
    cachedCamtingImages[camtingData.id]!!.map {  Observable.just(it) }
  })

  override fun isCached(uid: String): Boolean {

  }
}