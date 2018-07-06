package app.chemistry.camting.ui.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import app.chemistry.camting.ui.ScreenLayoutComponent
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.setContentView
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<ScreenLayout : ScreenLayoutComponent<out AppCompatActivity>> :
    DaggerAppCompatActivity(){

  abstract val screenLayout: ScreenLayout

  @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

  inline fun <reified T : ViewModel?> createViewModel() =
      ViewModelProviders.of(this, viewModelFactory).get(T::class.java)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (screenLayout as? AnkoComponent<AppCompatActivity>)?.setContentView(this)
  }

}