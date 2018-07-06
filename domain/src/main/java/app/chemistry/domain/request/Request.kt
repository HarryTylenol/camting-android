package app.chemistry.domain.request

interface Request {
  var limit : Parameters<Long>
  var requestParams: ArrayList<Parameters<*>>
}