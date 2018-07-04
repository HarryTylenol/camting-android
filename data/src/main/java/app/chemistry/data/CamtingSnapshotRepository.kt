package app.chemistry.data

interface CamtingSnapshotRepository {

  suspend fun getCamtingByUser(uid: String): CamtingData?
  suspend fun getCamtingById(id: String): CamtingData?

  suspend fun queryCamtingByParams() : List<CamtingData>

}