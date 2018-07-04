package app.chemistry.network.util

import com.google.firebase.firestore.FirebaseFirestore

class FirestoreReference {

  private val firestore = FirebaseFirestore.getInstance()

  fun getCamtingRef() = firestore.collection("camting")

  fun getUserRef() = firestore.collection("user")

}