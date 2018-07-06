package app.chemistry.camting.di.modules

import android.content.Context
import app.chemistry.camting.di.App
import app.chemistry.camting.ui.screen.MainActivityComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = arrayOf(
    MainActivityComponent::class
))
class AppModule {

  @Singleton
  @Provides
  internal fun provideContext(application: App): Context = application.applicationContext
}