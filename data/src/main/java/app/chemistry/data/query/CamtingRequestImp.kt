package app.chemistry.data.query

import app.chemistry.domain.request.CamtingRequest
import app.chemistry.domain.request.Parameters
import app.chemistry.domain.request.RequestParams

class CamtingRequestImp : CamtingRequest {

  override var memberCount: Parameters<Long> by RequestParams("categories.")
  override var gender: Parameters<Long> by RequestParams("categories.")
  override var school_id: Parameters<Long> by RequestParams("categories.")
  override var year: Parameters<Long> by RequestParams("categories.")
  override var no_smoke: Parameters<Long> by RequestParams("categories.")
  override var no_alcohol: Parameters<Long> by RequestParams("categories.")
  override var festival: Parameters<Long> by RequestParams("categories.")

  override var uid: Parameters<Boolean> by RequestParams("members.")

  override var limit: Parameters<Long> by RequestParams()

  override var requestParams: ArrayList<Parameters<*>> = arrayListOf()

}