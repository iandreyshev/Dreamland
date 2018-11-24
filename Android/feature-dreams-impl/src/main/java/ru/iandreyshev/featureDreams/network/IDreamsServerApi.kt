package ru.iandreyshev.featureDreams.network

import ru.iandreyshev.featureDreams.network.request.DeleteDreamRequest
import ru.iandreyshev.featureDreams.network.request.EditDreamRequest
import ru.iandreyshev.featureDreams.network.request.GetDreamsRequest
import ru.iandreyshev.featureDreams.network.request.SaveDreamRequest
import ru.iandreyshev.featureDreams.network.response.DeleteDreamResponse
import ru.iandreyshev.featureDreams.network.response.EditDreamResponse
import ru.iandreyshev.featureDreams.network.response.GetDreamsResponse
import ru.iandreyshev.featureDreams.network.response.SaveDreamResponse

interface IDreamsServerApi {
    fun getDreams(request: GetDreamsRequest): GetDreamsResponse
    fun save(request: SaveDreamRequest): SaveDreamResponse
    fun edit(request: EditDreamRequest): EditDreamResponse
    fun delete(request: DeleteDreamRequest): DeleteDreamResponse
}
