package ru.iandreyshev.dreamland.di

import ru.iandreyshev.dreamland.application.DreamlandApplication
import ru.iandreyshev.featureAccount.di.DaggerFeatureAccountComponent
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent

object FeatureProxyInjector {

    fun featureAccountComponent(): FeatureAccountComponent =
            DaggerFeatureAccountComponent.builder()
                    .application(DreamlandApplication.instance)
                    .build()

}