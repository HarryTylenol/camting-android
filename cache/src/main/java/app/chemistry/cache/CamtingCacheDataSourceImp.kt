package app.chemistry.cache

import app.chemistry.data.data.CamtingCacheDataSource
import app.chemistry.data.model.CamtingData

class CamtingCacheDataSourceImp : CamtingCacheDataSource {

  private val camtingCache: HashMap<String, CamtingData> = hashMapOf()

  override fun saveCamting(camtingData: CamtingData) {
    camtingCache.put("", camtingData)
  }

  override fun isCamtingCached(id: String) = camtingCache.contains(id)

  override suspend fun getCamting(id: String) = camtingCache[id]

}