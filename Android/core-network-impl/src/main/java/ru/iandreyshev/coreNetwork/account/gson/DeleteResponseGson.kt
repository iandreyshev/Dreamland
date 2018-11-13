package ru.iandreyshev.coreNetwork.account.gson

import com.google.gson.annotations.SerializedName
import ru.iandreyshev.coreNetworkApi.account.delete.DeleteResponse

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
            DeleteResponseGson.Error.USER_NOT_EXISTS -> DeleteResponse.Result.USER_NOT_EXISTS
            DeleteResponseGson.Error.NO_ACCESS -> DeleteResponse.Result.NO_ACCESS
            null -> DeleteResponse.Result.SUCCESS
        })
    }

}
