package ru.iandreyshev.featureMenu.di

import ru.iandreyshev.featureMenuApi.navigation.IMainPageFragmentProvider
import ru.iandreyshev.featureMenuApi.navigation.IMenuNavigator

interface IFeatureMenuDependencies {
    val navigator: IMenuNavigator
    val fragmentProvider: IMainPageFragmentProvider
}
