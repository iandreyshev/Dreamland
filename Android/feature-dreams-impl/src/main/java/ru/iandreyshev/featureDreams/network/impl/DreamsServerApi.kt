package ru.iandreyshev.featureDreams.network.impl

import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.network.request.DeleteDreamRequest
import ru.iandreyshev.featureDreams.network.request.EditDreamRequest
import ru.iandreyshev.featureDreams.network.request.GetDreamsRequest
import ru.iandreyshev.featureDreams.network.request.SaveDreamRequest
import ru.iandreyshev.featureDreams.network.response.DeleteDreamResponse
import ru.iandreyshev.featureDreams.network.response.EditDreamResponse
import ru.iandreyshev.featureDreams.network.response.GetDreamsResponse
import ru.iandreyshev.featureDreams.network.response.SaveDreamResponse
import javax.inject.Inject

class DreamsServerApi
@Inject constructor() : IDreamsServerApi {

    override fun getDreams(request: GetDreamsRequest): GetDreamsResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(request: SaveDreamRequest): SaveDreamResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun edit(request: EditDreamRequest): EditDreamResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(request: DeleteDreamRequest): DeleteDreamResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}