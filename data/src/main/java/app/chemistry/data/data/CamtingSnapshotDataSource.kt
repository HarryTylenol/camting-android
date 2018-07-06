package app.chemistry.data.data

import app.chemistry.data.model.CamtingData
import com.google.firebase.firestore.Query

interface CamtingSnapshotDataSource : CamtingDataSource {
  suspend fun requestCamtings(query: Query.() -> Query): List<CamtingData>
  suspend fun addCamting(camtingData: CamtingData): Boolean
}