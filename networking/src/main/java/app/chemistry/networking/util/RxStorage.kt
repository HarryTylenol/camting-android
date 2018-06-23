package app.chemistry.networking.util

import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import io.reactivex.Observable
import io.reactivex.Single

object RxStorage {

  fun getDownloadUrl(storageReference: StorageReference): Observable<String> {
    return Observable.create(RxObservableTask.create(storageReference.downloadUrl)).map { it.toString() }
  }

  fun putByteArray(storageReference: StorageReference, value: ByteArray): Single<UploadTask.TaskSnapshot> {
    return Single.create(RxSingleTask.create(storageReference.putBytes(value)))
  }

}