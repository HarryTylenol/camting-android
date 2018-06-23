package app.chemistry.networking.util

import com.google.firebase.firestore.DocumentReference
import io.reactivex.Single

object RxFirestore {

  inline fun <reified T> get(documentReference: DocumentReference): Single<T> {
    return Single.create(RxSingleTask.create(documentReference.get())).map { it.toObject(T::class.java) }
  }

  fun set(documentReference: DocumentReference, value: Any): Single<Void> {
    return Single.create(RxSingleTask.create(documentReference.set(value)))
  }

}