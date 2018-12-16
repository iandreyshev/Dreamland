package ru.iandreyshev.featureDreams.network

import ru.iandreyshev.featureDreams.network.request.DeleteDreamRequest
import ru.iandreyshev.featureDreams.network.request.EditRequest
import ru.iandreyshev.featureDreams.network.request.FetchDreamsRequest
import ru.iandreyshev.featureDreams.network.request.SaveRequest
import ru.iandreyshev.featureDreams.network.response.DeleteResponse
import ru.iandreyshev.featureDreams.network.response.EditResponse
import ru.iandreyshev.featureDreams.network.response.FetchDreamsResponse
import ru.iandreyshev.featureDreams.network.response.SaveResponse

interface IDreamsServerApi {
    fun fetchDreams(request: FetchDreamsRequest): FetchDreamsResponse
    fun save(request: SaveRequest): SaveResponse
    fun edit(request: EditRequest): EditResponse
    fun delete(request: DeleteDreamRequest): DeleteResponse
}
