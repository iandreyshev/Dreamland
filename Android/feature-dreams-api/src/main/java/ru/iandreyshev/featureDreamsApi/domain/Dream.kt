package ru.iandreyshev.featureDreamsApi.domain

import android.os.Bundle

data class Dream(
        val key: DreamKey,
        val properties: DreamProperties
) {

    fun toBundle(): Bundle {
        return Bundle().apply {
            putBundle(KEY_KEY, key.toBundle())
            putBundle(KEY_PROPERTIES, properties.toBundle())
        }
    }

    companion object {
        private const val KEY_KEY = "key_key"
        private const val KEY_PROPERTIES = "key_properties"

        fun create(bundle: Bundle?): Dream? {
            bundle ?: return null

            val key = bundle.getBundle(KEY_KEY)
                    ?.let(DreamKey.Companion::create) ?: return null

            val properties = bundle.getBundle(KEY_PROPERTIES)
                    ?.let(DreamProperties.Companion::create)
                    ?: return null

            return Dream(key, properties)
        }
    }

}
