package ru.iandreyshev.featureDreams.di

import dagger.Module
import dagger.Provides
import ru.iandreyshev.featureDreams.ui.fragment.MyDreamsFragment
import ru.iandreyshev.featureDreamsApi.IDreamsDiaryFragmentFactory

@Module
class FeatureDreamsModule {

    @Provides
    fun provideDreamsDiaryFragmentFactory(): IDreamsDiaryFragmentFactory {
        return object : IDreamsDiaryFragmentFactory {
            override fun create() = MyDreamsFragment()
        }
    }

}
