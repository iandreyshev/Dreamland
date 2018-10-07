package ru.iandreyshev.featureAccount.di

import dagger.Component
import ru.iandreyshev.featureAccount.model.repository.IUserRepository
import ru.iandreyshev.featureAccount.viewModel.ViewModelFactory
import javax.inject.Singleton

@Component(
        modules = [FeatureAccountModule::class]
)
@Singleton
abstract class FeatureAccountComponent {
    abstract fun inject(vmFactory: ViewModelFactory)
    abstract fun getUserRepository(): IUserRepository
}
