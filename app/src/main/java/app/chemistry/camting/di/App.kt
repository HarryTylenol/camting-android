package app.chemistry.camting.di

import android.app.Activity
import android.app.Application
import app.chemistry.camting.di.components.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

  //TODO REMINDER: register this class in AndroidManifest.xml

  @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent
        .builder()
        .application(this)
        .build()
        .inject(this)
  }

  override fun activityInjector(): DispatchingAndroidInjector<Activity> = dispatchingAndroidInjector
}