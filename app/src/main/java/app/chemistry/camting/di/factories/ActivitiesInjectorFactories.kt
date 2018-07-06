package app.chemistry.camting.di.factories

import android.app.Activity
import app.chemistry.camting.ui.screen.MainActivity
import app.chemistry.camting.ui.screen.MainActivityComponent
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
  abstract fun bindMainActivity(
      builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}