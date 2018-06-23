package app.chemistry.camting.ui.screen

import android.view.View
import app.chemistry.camting.ui.ScreenLayoutComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout
import javax.inject.Inject

class MainScreenLayout @Inject constructor(override val layoutContext: MainActivity) : ScreenLayoutComponent<MainActivity> {
  override val createView: AnkoContext<MainActivity>.() -> View = {
    verticalLayout {

    }
  }
}