package app.chemistry.data.data

import app.chemistry.data.model.CamtingData

interface CamtingDataSource {

  suspend fun getCamting(id: String): CamtingData?

}