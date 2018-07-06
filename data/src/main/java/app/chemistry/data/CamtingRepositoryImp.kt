package app.chemistry.data

import app.chemistry.data.data.CamtingDataSourceFactory
import app.chemistry.domain.model.CamtingDomain
import app.chemistry.domain.repository.CamtingRepository
import app.chemistry.domain.request.CamtingRequest

class CamtingRepositoryImp(val camtingDataSourceFactory: CamtingDataSourceFactory) :
    CamtingRepository {

  override suspend fun getCamtingByUser(uid: String): CamtingDomain? {
    return camtingDataSourceFactory.provideSnapshotRepository()
        .getCamting(uid)?.toDomain()
  }

  override suspend fun getCamtingById(id: String): CamtingDomain? {
    return camtingDataSourceFactory.provideRepository(id)
        .getCamting(id)?.toDomain()
  }

  override suspend fun requestCamtings(request: CamtingRequest): List<CamtingDomain> {
    return camtingDataSourceFactory.provideSnapshotRepository()
        .requestCamtings { applyRequest(request) }
        .toDomain()
  }

  override suspend fun addCamting(camtingDomain: CamtingDomain) {
    camtingDataSourceFactory.provideSnapshotRepository()
        .addCamting(camtingDomain.toData())
  }
}