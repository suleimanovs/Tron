package kz.android.tron.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.android.tron.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by osmanboy on 2/26/2022.
 */
@Suppress("UNCHECKED_CAST")
@ApplicationScope
class MovieModelFactory @Inject constructor(
    private val viewModelProviders: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelProviders[modelClass]?.get() as T
    }
}