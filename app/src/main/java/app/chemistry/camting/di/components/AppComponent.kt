package app.chemistry.camting.di.components

import app.chemistry.cache.di.CacheModule
import app.chemistry.camting.di.App
import app.chemistry.camting.di.factories.ActivitiesInjectorFactories
import app.chemistry.camting.di.factories.FragmentsInjectorFactories
import app.chemistry.camting.di.modules.AppModule
import app.chemistry.data.di.DataModule
import app.chemistry.domain.di.DomainModule
import app.chemistry.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    ActivitiesInjectorFactories::class,
    FragmentsInjectorFactories::class,
    CacheModule::class,
    NetworkModule::class,
    DataModule::class,
    DomainModule::class,
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