package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName
import ru.iandreyshev.featureAccount.network.response.DeleteResponse

class DeleteResponseGson(
        @SerializedName("error")
        val error: DeleteResponseGson.Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS,
        @SerializedName("1")
        NO_ACCESS;

    }

    fun toApiModel(): DeleteResponse {
        return DeleteResponse(when (error) {
            Error.USER_NOT_EXISTS -> DeleteResponse.Result.USER_NOT_EXISTS
            Error.NO_ACCESS -> DeleteResponse.Result.NO_ACCESS
            null -> DeleteResponse.Result.SUCCESS
        })
    }

}
