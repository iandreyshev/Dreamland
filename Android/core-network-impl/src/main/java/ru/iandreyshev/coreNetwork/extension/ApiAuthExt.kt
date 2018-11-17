package ru.iandreyshev.coreNetwork.extension

import ru.iandreyshev.coreNetwork.httpClient.HEADER_ACCOUNT_ID
import ru.iandreyshev.coreNetwork.httpClient.HEADER_PASSWORD
import ru.iandreyshev.coreNetworkApi.ApiAuth

internal val ApiAuth.headers: Map<String, String>
    get() = mapOf(
            HEADER_ACCOUNT_ID to userId.toString(),
            HEADER_PASSWORD to password
    )
