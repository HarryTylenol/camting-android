package app.chemistry.camting.di.factories

import android.app.Activity
import app.chemistry.camting.ui.screen.MainActivity
import app.chemistry.camting.ui.screen.MainActivitySubComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivitiesInjectorFactories {

  @Binds
  @IntoMap
  @ActivityKey(MainActivity::class)
  internal abstract fun bindMainActivityInjectorFactory(
      builder: MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

}