package app.chemistry.data.model

data class CamtingData(
    val id: String,
    val name: String,
    val memberCount: Int,
    val memberList: Map<String, String>
) {

  fun map() = mapOf(
      "name" to name,
      "memberCount" to Int,
      "memberList" to memberList
  )

}