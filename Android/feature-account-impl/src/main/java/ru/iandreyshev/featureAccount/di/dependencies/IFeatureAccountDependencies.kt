package ru.iandreyshev.featureAccount.di.dependencies

interface IFeatureAccountDependencies {
    val contextProvider: IContextProvider
    val navigator: IAccountNavigator
}
