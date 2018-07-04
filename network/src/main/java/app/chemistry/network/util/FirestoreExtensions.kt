package app.chemistry.network.util

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.Query
import kotlinx.coroutines.experimental.NonCancellable
import kotlinx.coroutines.experimental.suspendCancellableCoroutine

inline fun Query.runQuery(operator: Query.() -> Query) = this.operator()

suspend inline fun <reified T> Query.await(): List<T> =
    get().await().map { it.toObject(T::class.java) }.filter { it != null }

suspend inline fun <reified T> DocumentReference.await(): T? =
    get().await().toObject(T::class.java)

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