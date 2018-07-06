package app.chemistry.camting.ui.screen

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<A : FragmentActivity> : DaggerFragment() {

  @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

  inline fun <reified T : ViewModel?> getViewModel() =
      ViewModelProviders.of(requireActivity(), viewModelFactory).get(T::class.java)

  override fun onAttach(context: Context?) {
    super.onAttach(context)
  }


}