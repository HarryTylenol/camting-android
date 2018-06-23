package app.chemistry.camting.ui.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.chemistry.camting.ui.ScreenLayoutComponent
import dagger.android.AndroidInjection
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.setContentView

abstract class BaseActivity<ScreenLayout : ScreenLayoutComponent<out AppCompatActivity>> : AppCompatActivity() {

  abstract val screenLayout: ScreenLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    (screenLayout as? AnkoComponent<AppCompatActivity>)?.setContentView(this)
  }

}