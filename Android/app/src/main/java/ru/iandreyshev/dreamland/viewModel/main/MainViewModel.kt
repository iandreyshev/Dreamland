package ru.iandreyshev.dreamland.viewModel.main

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import ru.iandreyshev.coreAndroidUtils.mutableLiveDataOf
import ru.iandreyshev.coreAndroidUtils.observeNotNull
import ru.iandreyshev.featureAccount.model.repository.IUser
import ru.iandreyshev.featureAccount.model.repository.IUserRepository

class MainViewModel(mUserRepository: IUserRepository) : ViewModel() {

    private val mState = mutableLiveDataOf<MainViewModelState>(MainViewModelState.WaitState)

    init {
        mUserRepository.getUser(object : SingleObserver<IUser> {
            override fun onSuccess(user: IUser) {
                val completeState = MainViewModelState.CompleteState(user.isSignIn)
                mState.postValue(completeState)
            }

            override fun onSubscribe(d: Disposable) = Unit
            override fun onError(e: Throwable) = Unit
        })
    }

    fun observeState(lifecycleOwner: LifecycleOwner, observer: (MainViewModelState) -> Unit) =
            mState.observeNotNull(lifecycleOwner, observer)

}
