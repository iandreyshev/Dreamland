package ru.iandreyshev.featureDreams.network.impl

import com.google.gson.Gson
import ru.iandreyshev.coreNetworkApi.api.IHttpClient
import ru.iandreyshev.coreNetworkApi.data.ApiRequestOptions
import ru.iandreyshev.coreNetworkApi.data.Request
import ru.iandreyshev.coreNetworkApi.data.Response
import ru.iandreyshev.featureDreams.mapping.toApplicationModel
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.network.parser.*
import ru.iandreyshev.featureDreams.network.request.DeleteDreamRequest
import ru.iandreyshev.featureDreams.network.request.EditRequest
import ru.iandreyshev.featureDreams.network.request.FetchDreamsRequest
import ru.iandreyshev.featureDreams.network.request.SaveRequest
import ru.iandreyshev.featureDreams.network.response.DeleteResponse
import ru.iandreyshev.featureDreams.network.response.EditResponse
import ru.iandreyshev.featureDreams.network.response.FetchDreamsResponse
import ru.iandreyshev.featureDreams.network.response.SaveResponse
import javax.inject.Inject

class DreamsServerApi
@Inject constructor(
        private val httpClient: IHttpClient
) : IDreamsServerApi {

    private val mJsonParser = Gson()

    override fun fetchDreams(request: FetchDreamsRequest): FetchDreamsResponse {
        val apiOptions = ApiRequestOptions(
                userId = request.userId,
                password = request.userPassword,
                path = PATH_FETCH
        )
        val apiResponse = httpClient.get(Request(), apiOptions)

        when (apiResponse.error) {
            Response.Error.CONNECTION ->
                return FetchDreamsResponse(FetchDreamsResponse.Error.NO_CONNECTION)
            Response.Error.PARSING,
            Response.Error.UNDEFINED ->
                return FetchDreamsResponse(FetchDreamsResponse.Error.SERVER_ERROR)
        }

        return mJsonParser
                .fromJson(apiResponse.bodyString, FetchResponseJson::class.java)
                .toApplicationModel()
    }

    override fun save(request: SaveRequest): SaveResponse {
        val requestBody = SaveRequestBodyJson(request)
        val apiRequest = Request(body = mJsonParser.toJson(requestBody))
        val apiOptions = ApiRequestOptions(
                userId = request.userId,
                password = request.userPassword,
                path = PATH_SAVE
        )
        val apiResponse = httpClient.post(apiRequest, apiOptions)

        when (apiResponse.error) {
            Response.Error.CONNECTION ->
                return SaveResponse(SaveResponse.Error.NO_CONNECTION)
            Response.Error.PARSING,
            Response.Error.UNDEFINED ->
                return SaveResponse(SaveResponse.Error.SERVER_ERROR)
        }

        return mJsonParser.fromJson(apiResponse.bodyString, SaveResponseJson::class.java)
                .toApplicationModel()
    }

    override fun edit(request: EditRequest): EditResponse {
        val requestBody = EditRequestBodyJson(request)
        val apiRequest = Request(body = mJsonParser.toJson(requestBody))
        val apiOptions = ApiRequestOptions(
                userId = request.userId,
                password = request.userPassword,
                path = PATH_EDIT
        )
        val apiResponse = httpClient.post(apiRequest, apiOptions)

        when (apiResponse.error) {
            Response.Error.CONNECTION ->
                return EditResponse.ERROR_NO_CONNECTION
            Response.Error.PARSING,
            Response.Error.UNDEFINED ->
                return EditResponse.ERROR_SERVER_ERROR
        }

        return mJsonParser.fromJson(apiResponse.bodyString, EditResponseJson::class.java)
                .toApplicationModel()
    }

    override fun delete(request: DeleteDreamRequest): DeleteResponse {
        val apiRequest = Request(query = mapOf(
                QUERY_DREAM_ID to request.id.toString()
        ))
        val apiOptions = ApiRequestOptions(
                userId = request.userId,
                password = request.userPassword,
                path = PATH_DELETE
        )
        val apiResponse = httpClient.delete(apiRequest, apiOptions)

        when (apiResponse.error) {
            Response.Error.CONNECTION ->
                return DeleteResponse.ERROR_NO_CONNECTION
            Response.Error.PARSING,
            Response.Error.UNDEFINED ->
                return DeleteResponse.ERROR_SERVER_ERROR
        }

        return mJsonParser.fromJson(apiResponse.bodyString, DeleteResponseJson::class.java)
                .toApplicationModel()
    }

    companion object {
        private const val PATH_FETCH = "/dreams/fetch"
        private const val PATH_SAVE = "/dreams/save"
        private const val PATH_EDIT = "/dreams/edit"
        private const val PATH_DELETE = "/dreams/delete"

        private const val QUERY_DREAM_ID = "dreamId"
    }

}