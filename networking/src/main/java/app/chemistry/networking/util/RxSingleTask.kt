package app.chemistry.networking.util

import com.google.android.gms.tasks.Task
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe

class RxSingleTask<T>(val task: Task<T>) : SingleOnSubscribe<T> {

  companion object {
    fun <T> create(task: Task<T>) = RxSingleTask(task)
  }

  override fun subscribe(emitter: SingleEmitter<T>) {
    task.addOnSuccessListener(emitter::onSuccess).addOnFailureListener(emitter::onError)
  }
}

