package app.chemistry.camting.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.chemistry.camting.util.SuspendLiveData
import app.chemistry.camting.util.switchMap
import app.chemistry.domain.repository.CamtingRepository
import javax.inject.Inject

class CamtingViewModel @Inject constructor(val camtingRepository: CamtingRepository) : ViewModel() {

  private val uid = MutableLiveData<String>()
  private val requestedCamtingId = MutableLiveData<String>()

  val myCamting = uid.switchMap {
    SuspendLiveData {
      camtingRepository.getCamtingById(this)
    }
  }

  val requestedCamting = requestedCamtingId.switchMap {
    SuspendLiveData {
      camtingRepository.getCamtingById(this)
    }
  }

  fun requestMyCamting(uid: String) {
    this.uid.value = uid
  }

  fun requestCamting(id: String) {
    this.requestedCamtingId.value = id
  }

}