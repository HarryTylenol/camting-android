package app.chemistry.camting.di.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.chemistry.camting.ui.viewmodel.CamtingViewModel
import app.chemistry.camting.util.ViewModelFactory
import app.chemistry.camting.util.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelInjectorFactories {

  @Binds
  @IntoMap
  @ViewModelKey(CamtingViewModel::class)
  internal abstract fun bindCamtingViewModel(camtingViewModel: CamtingViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}