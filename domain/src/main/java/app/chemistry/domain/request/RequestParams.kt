package app.chemistry.domain.request

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

data class Parameters<T : Any>(val value: T, val requestType: RequestType) {
  var propertyName: String by Delegates.notNull()
}

class RequestParams<T : Any>(val prefixSubDirectory: String = "",
                             private val customPropertyName: String? = null) :
    ReadWriteProperty<Request, Parameters<T>> {

  private var parameters: Parameters<T> by Delegates.notNull()

  override fun getValue(thisRef: Request, property: KProperty<*>): Parameters<T> {
    return parameters
  }

  override fun setValue(thisRef: Request, property: KProperty<*>, value: Parameters<T>) {
    val propertyName = "$prefixSubDirectory${customPropertyName ?: property.name}"
    this.parameters = value.apply { this.propertyName = propertyName }
    thisRef.requestParams.add(parameters)
  }

}