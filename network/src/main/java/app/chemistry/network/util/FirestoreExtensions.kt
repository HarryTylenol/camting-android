package app.chemistry.network.util

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import kotlinx.coroutines.experimental.NonCancellable
import kotlinx.coroutines.experimental.suspendCancellableCoroutine

suspend inline fun <reified T> Query.await(
    operator: T.(QueryDocumentSnapshot) -> T = { this }): List<T> =
    get().await().map { it.toObject(T::class.java).operator(it) }.filter { it != null }

suspend inline fun <reified T> DocumentReference.await(
    operator: T.(DocumentSnapshot) -> T = { this }): T? =
    get().await().run { toObject(T::class.java)?.operator(this) }

suspend fun <T> Task<T>.await(): T = suspendCancellableCoroutine { continuation ->
  addOnCompleteListener { task ->
    if (task.isSuccessful) continuation.resume(task.result)
    else continuation.resumeWithException(task.exception!!)
  }
  continuation.invokeOnCompletion {
    if (continuation.isCancelled)
      try {
        NonCancellable.cancel()
      }
      catch (ex: Throwable) {
      }
  }
}