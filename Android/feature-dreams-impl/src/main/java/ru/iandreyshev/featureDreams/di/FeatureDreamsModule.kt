package ru.iandreyshev.featureDreams.di

import dagger.Module
import dagger.Provides
import ru.iandreyshev.featureDreams.fragment.DreamsDiaryFragment
import ru.iandreyshev.featureDreamsApi.data.IDreamsDiaryFragmentFactory

@Module
class FeatureDreamsModule {

    @Provides
    fun provideDreamsDiaryFragmentFactory(): IDreamsDiaryFragmentFactory {
        return object : IDreamsDiaryFragmentFactory {
            override fun create() = DreamsDiaryFragment()
        }
    }

}
