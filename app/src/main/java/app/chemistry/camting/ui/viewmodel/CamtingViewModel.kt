package app.chemistry.camting.ui.viewmodel

import androidx.lifecycle.ViewModel
import app.chemistry.domain.repository.CamtingRepository
import javax.inject.Inject

class CamtingViewModel @Inject constructor(val camtingRepository: CamtingRepository) : ViewModel() {



}