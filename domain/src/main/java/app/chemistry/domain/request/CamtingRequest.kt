package app.chemistry.domain.request

interface CamtingRequest : Request {

  var memberCount: Parameters<Long>
  var gender: Parameters<Long>
  var school_id: Parameters<Long>
  var year: Parameters<Long>
  var no_smoke: Parameters<Long>
  var no_alcohol: Parameters<Long>
  var festival: Parameters<Long>

  var uid: Parameters<Boolean>

}
