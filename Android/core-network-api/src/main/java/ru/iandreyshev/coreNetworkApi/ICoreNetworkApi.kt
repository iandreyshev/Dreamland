package ru.iandreyshev.coreNetworkApi

import ru.iandreyshev.coreNetworkApi.account.IAccountNetworkApi

interface ICoreNetworkApi {
    val accountNetworkApi: IAccountNetworkApi
}