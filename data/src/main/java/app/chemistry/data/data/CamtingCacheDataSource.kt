package app.chemistry.data.data

import app.chemistry.data.model.CamtingData

interface CamtingCacheDataSource : CamtingDataSource {
  fun saveCamting(camtingData: CamtingData)
  fun isCamtingCached(id : String): Boolean
}