package ru.iandreyshev.dreamland.di

import android.content.Context
import ru.iandreyshev.dreamland.navigation.FeatureAccountNavigator
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent

object FeatureProxyInjector {

    private val mFeatureAccountNavigator = FeatureAccountNavigator()

    fun featureAccountComponent(context: Context): FeatureAccountComponent =
            DaggerFeatureAccountComponent.builder()
                    .iAuthNavigator(mFeatureAccountNavigator)
                    .iAccountNavigator(mFeatureAccountNavigator)
                    .context(context)
                    .build()

}