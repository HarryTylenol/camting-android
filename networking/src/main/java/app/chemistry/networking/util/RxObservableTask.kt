package app.chemistry.networking.util

import com.google.android.gms.tasks.Task
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe


class RxObservableTask<T>(val task: Task<T>) : ObservableOnSubscribe<T> {

  companion object {
    fun <T> create(task: Task<T>) = RxObservableTask(task)
  }

  override fun subscribe(emitter: ObservableEmitter<T>) {
    task.addOnSuccessListener(emitter::onNext)
        .addOnFailureListener(emitter::onError)
        .addOnCompleteListener { emitter.onComplete() }
  }

}