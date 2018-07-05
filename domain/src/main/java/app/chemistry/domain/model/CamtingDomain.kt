package app.chemistry.domain.model

data class CamtingDomain(val id: String,
                    var categories: HashMap<String, Any> = hashMapOf(),
                    var members: HashMap<String, Boolean>
)