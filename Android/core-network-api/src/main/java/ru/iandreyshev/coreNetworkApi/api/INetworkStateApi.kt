package ru.iandreyshev.coreNetworkApi.api

import io.reactivex.Observable
import ru.iandreyshev.coreNetworkApi.data.NetworkState

interface INetworkStateApi {
    val observable: Observable<NetworkState>
}
