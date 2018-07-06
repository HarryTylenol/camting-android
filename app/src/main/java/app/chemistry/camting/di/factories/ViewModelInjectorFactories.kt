package app.chemistry.camting.di.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.chemistry.camting.ui.viewmodel.CamtingViewModel
import app.chemistry.camting.util.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Suppress("unused")
@Module
abstract class ViewModelInjectorFactories {

  @Binds
  @IntoMap
  @ViewModelKey(CamtingViewModel::class)
  abstract fun bindCamtingViewModel(userViewModel: CamtingViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}