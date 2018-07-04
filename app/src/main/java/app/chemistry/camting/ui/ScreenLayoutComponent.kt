package app.chemistry.camting.ui

import android.content.Context
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

interface ScreenLayoutComponent<T> : AnkoComponent<T> {

  val layoutContext: T
  fun inflate(context: Context): View = this.createView(AnkoContext.create(context, layoutContext))
  val createView: AnkoContext<T>.() -> View

  override fun createView(ui: AnkoContext<T>) = ui.createView()

}