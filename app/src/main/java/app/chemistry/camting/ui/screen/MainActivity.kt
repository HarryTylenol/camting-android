package app.chemistry.camting.ui.screen

import javax.inject.Inject

class MainActivity : BaseActivity<MainScreenLayout>() {
  @Inject override lateinit var screenLayout: MainScreenLayout

}