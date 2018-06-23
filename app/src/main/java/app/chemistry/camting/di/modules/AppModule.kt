package app.chemistry.camting.di.modules

import android.content.Context
import app.chemistry.camting.di.App
import app.chemistry.camting.ui.screen.MainActivitySubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = arrayOf(
    MainActivitySubComponent::class
))
class AppModule {

  @Singleton
  @Provides
  internal fun provideContext(application: App): Context = application.applicationContext
}