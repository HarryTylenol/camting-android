package app.chemistry.networking

import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.concurrent.TimeUnit.*

class FirebaseNetworkingServiceFactory {

  private val storage: FirebaseStorage = FirebaseStorage.getInstance()
  private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
  private val auth: FirebaseAuth = FirebaseAuth.getInstance()
  private val phoneAuth: PhoneAuthProvider = PhoneAuthProvider.getInstance()

  fun provideAuth() = auth

  fun provideFirestore() = firestore
  fun provideStorage() = storage


}