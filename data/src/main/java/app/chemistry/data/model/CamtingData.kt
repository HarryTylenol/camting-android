package app.chemistry.data.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class CamtingData(var id: String,
                       var categories: HashMap<String, Any> = hashMapOf(),
                       var members: HashMap<String, Boolean>
)