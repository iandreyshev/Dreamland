package ru.iandreyshev.featureDreamsApi.domain

import android.os.Bundle
import java.io.Serializable

class DreamKey constructor(val id: Long) : Serializable {

    fun toBundle(): Bundle {
        return Bundle().apply {
            putLong(ID_KEY, id)
        }
    }

    companion object {
        private const val ID_KEY = "key_id"

        @JvmStatic
        fun create(bundle: Bundle?): DreamKey? {
            bundle ?: return null

            if (!bundle.containsKey(ID_KEY)) {
                return null
            }

            return DreamKey(bundle.getLong(ID_KEY))
        }
    }
}
