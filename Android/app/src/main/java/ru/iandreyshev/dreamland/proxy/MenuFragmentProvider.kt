package ru.iandreyshev.dreamland.proxy

import android.support.v4.app.Fragment
import ru.iandreyshev.featureMenuApi.navigation.IMainPageFragmentProvider
import ru.iandreyshev.dreams.presentation.fragment.DreamsDiaryFragment

class MenuFragmentProvider : IMainPageFragmentProvider {

    override fun getFragment(): Fragment {
        return DreamsDiaryFragment()
    }

}
