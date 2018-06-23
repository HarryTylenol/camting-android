package app.chemistry.camting.di.components

import app.chemistry.camting.di.App
import app.chemistry.camting.di.factories.ActivitiesInjectorFactories
import app.chemistry.camting.di.factories.FragmentsInjectorFactories
import app.chemistry.camting.di.modules.AppModule
import app.chemistry.networking.NetworkingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    ActivitiesInjectorFactories::class,
    FragmentsInjectorFactories::class,
    NetworkingModule::class,
    AppModule::class
))
interface AppComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: App): Builder

    fun build(): AppComponent
  }

  fun inject(app: App)

}