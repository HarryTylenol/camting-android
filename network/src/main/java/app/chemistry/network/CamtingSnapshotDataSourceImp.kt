package app.chemistry.network

import app.chemistry.data.data.CamtingSnapshotDataSource
import app.chemistry.data.model.CamtingData
import app.chemistry.network.util.await
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.Query

open class CamtingSnapshotDataSourceImp(val collectionReference: CollectionReference) :
    CamtingSnapshotDataSource {

  override suspend fun requestCamtings(query: Query.() -> Query): List<CamtingData> {
    return collectionReference.query().await {
      this.id = it.id
      this
    }
  }

  override suspend fun addCamting(camtingData: CamtingData): Boolean {
    try {
      collectionReference.add(camtingData).await()
      return true
    }
    catch (e: Exception) {
      e.printStackTrace()
      return false
    }
  }

  override suspend fun getCamting(id: String): CamtingData? {
    return collectionReference.document(id).await {
      this?.id = it.id
      this
    }
  }

}