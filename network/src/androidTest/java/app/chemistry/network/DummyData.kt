package app.chemistry.network

import app.chemistry.data.model.CamtingData
import java.util.*

object DummyData {

  fun randomUuid(): String {
    return UUID.randomUUID().toString()
  }

  fun camtingData() =
      CamtingData(
          categories = hashMapOf(
              "no_alcohol" to System.currentTimeMillis(),
              "no_smoking" to System.currentTimeMillis(),
              "festival" to System.currentTimeMillis()
          ),
          members = hashMapOf(
              randomUuid() to true
          )
      )

}