package app.chemistry.data

import app.chemistry.data.model.CamtingData
import app.chemistry.domain.model.CamtingDomain
import app.chemistry.domain.request.Request
import app.chemistry.domain.request.RequestType
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.Query.Direction.*

fun CamtingData.toDomain() = CamtingDomain(id, categories, members)
fun CamtingDomain.toData() = CamtingData(id, categories, members)

fun List<CamtingData>.toDomain() = this.map { it.run { CamtingDomain(id, categories, members) } }
fun List<CamtingDomain>.toData() = this.map { it.run { CamtingData(id, categories, members) } }

fun Query.applyRequest(request: Request) = this.apply {
  var query = this
  request.requestParams.forEach {
    query = when (it.requestType) {
      RequestType.ORDER_BY_ASC              -> query.orderBy(it.propertyName, ASCENDING)
      RequestType.ORDER_BY_DESC             -> query.orderBy(it.propertyName, DESCENDING)
      RequestType.GREATER_THAN              -> query.whereGreaterThan(it.propertyName, it.value)
      RequestType.LESS_THEN                 -> query.whereLessThan(it.propertyName, it.value)
      RequestType.GREATER_THAN_OR_EQUALS_TO -> query.whereGreaterThanOrEqualTo(it.propertyName,
                                                                               it.value)
      RequestType.LESS_THEN_OR_EQUALS_TO    -> query.whereLessThanOrEqualTo(it.propertyName,
                                                                            it.value)
      RequestType.EQUALS_TO                 -> query.whereEqualTo(it.propertyName, it.value)
      RequestType.LIMIT                     -> query.limit(it.value as Long)
    }
  }
  return query
}