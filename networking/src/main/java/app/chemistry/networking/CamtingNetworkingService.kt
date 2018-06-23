package app.chemistry.networking

import app.chemistry.data.model.CamtingData
import app.chemistry.data.camting.CamtingRequest
import app.chemistry.networking.util.RxFirestore
import app.chemistry.networking.util.RxStorage
import io.reactivex.Observable
import io.reactivex.Single

class CamtingNetworkingService(var firebaseNetworkingServiceFactory: FirebaseNetworkingServiceFactory) : CamtingRequest {

  fun getCamting(uid: String) = firebaseNetworkingServiceFactory.provideFirestore().collection("camting").document(uid)
  fun getCamtingImages(uid: String, memberCount: Int) = firebaseNetworkingServiceFactory.provideStorage().getReference("camting")
      .child(uid)
      .child("${memberCount}.png")

  override fun getByUid(uid: String): Single<CamtingData> =
      RxFirestore.get(getCamting(uid))

  override fun getImages(camtingData: CamtingData): Observable<String> =
      Observable.merge(
          (0 until camtingData.memberCount).mapIndexed { index, i ->
            RxStorage.getDownloadUrl(getCamtingImages(camtingData.id, i))
          }
      )

  override fun isCached(uid: String): Boolean {
    throw UnsupportedOperationException()
  }
}