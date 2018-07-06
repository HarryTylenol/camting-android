package app.chemistry.camting.ui.screen

import android.os.Bundle
import app.chemistry.camting.ui.MainActivityScreenController
import app.chemistry.camting.ui.viewmodel.CamtingViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<MainScreenLayout>() {

  @Inject override lateinit var screenLayout: MainScreenLayout
  @Inject lateinit var activityScreenController: MainActivityScreenController

  lateinit var camtingViewModel: CamtingViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    camtingViewModel = createViewModel()
  }


}