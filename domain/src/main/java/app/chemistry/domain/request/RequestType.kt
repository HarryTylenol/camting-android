package app.chemistry.domain.request

enum class RequestType {
  ORDER_BY_ASC,
  ORDER_BY_DESC,
  GREATER_THAN,
  LESS_THEN,
  GREATER_THAN_OR_EQUALS_TO,
  LESS_THEN_OR_EQUALS_TO,
  EQUALS_TO,
  LIMIT
}