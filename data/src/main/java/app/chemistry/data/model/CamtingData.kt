package app.chemistry.data.model

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class CamtingData(@Exclude var id: String = "",
                       var categories: HashMap<String, Any> = hashMapOf(),
                       var members: HashMap<String, Boolean>
)