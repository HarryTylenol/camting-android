package app.chemistry.camting.di.factories

import androidx.fragment.app.Fragment
import app.chemistry.camting.ui.screen.login.LoginFragment
import app.chemistry.camting.ui.screen.login.LoginFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(
    LoginFragmentComponent::class
))
abstract class FragmentsInjectorFactories {

  @Binds
  @IntoMap
  @FragmentKey(LoginFragment::class)
  abstract fun bindLoginFragment(
      builder: LoginFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>
}