package app.chemistry.domain.repository

import app.chemistry.domain.model.Camting

interface CamtingRepository {

  suspend fun getCamtingByUser(uid: String): Camting?
  suspend fun getCamtingById(id: String): Camting?

  suspend fun queryCamtingByParams(

  ): List<Camting>

}