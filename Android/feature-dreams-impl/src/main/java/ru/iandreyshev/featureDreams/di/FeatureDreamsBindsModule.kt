package ru.iandreyshev.featureDreams.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.coreAndroid.di.scope.PerFeature
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.network.impl.DreamsServerApi
import ru.iandreyshev.featureDreams.repository.DreamsRepository
import ru.iandreyshev.featureDreams.storage.IDraftStorage
import ru.iandreyshev.featureDreams.storage.impl.DraftStorage
import ru.iandreyshev.featureDreams.storage.impl.DreamsStorage
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import javax.inject.Singleton

@Module
abstract class FeatureDreamsBindsModule {

    @Binds
    @PerFeature
    abstract fun bindDreamsRepository(repository: DreamsRepository): IDreamsRepository

    @Binds
    @PerFeature
    abstract fun bindDreamsServerApi(serverApi: DreamsServerApi): IDreamsServerApi

    @Binds
    @PerFeature
    abstract fun bindDreamsStorage(storage: DreamsStorage): IDreamsStorage

    @Binds
    @PerFeature
    abstract fun bindDraftStorage(storage: DraftStorage): IDraftStorage

}
