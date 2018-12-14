package ru.iandreyshev.featureDreams.di

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import ru.iandreyshev.coreAndroid.di.context.IContextProvider
import ru.iandreyshev.coreAndroid.di.scope.PerFeature
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreams.storage.entity.MyObjectBox
import ru.iandreyshev.featureDreams.ui.fragment.MyDreamsFragment
import ru.iandreyshev.featureDreamsApi.api.IDreamsDiaryFragmentFactory
import javax.inject.Singleton

@Module
class FeatureDreamsModule {

    @Provides
    @PerFeature
    fun provideBoxStore(contextProvider: IContextProvider): BoxStore =
            MyObjectBox.builder()
                    .androidContext(contextProvider.context)
                    .name("FeatureDreams")
                    .build()

    @Provides
    @PerFeature
    fun provideDreamsBox(boxStore: BoxStore): Box<DreamStorageEntity> =
            boxStore.boxFor(DreamStorageEntity::class.java)

    @Provides
    @PerFeature
    fun provideDreamsDiaryFragmentFactory(): IDreamsDiaryFragmentFactory {
        return object : IDreamsDiaryFragmentFactory {
            override fun create() = MyDreamsFragment()
        }
    }

}
