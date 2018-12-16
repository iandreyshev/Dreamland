package ru.iandreyshev.featureDreamsApi.domain

import android.os.Bundle

data class DreamProperties(
        val description: String,
        val sleepingDate: SleepingDate = SleepingDate(0),
        val isLucid: Boolean = false
) {

    fun toBundle(): Bundle {
        return Bundle().apply {
            putString(KEY_DESCRIPTION, description)
        }
    }

    companion object {
        private const val KEY_DESCRIPTION = "key_description"
        private const val KEY_SLEEPING_DATE = "key_sleeping_date"

        fun create(bundle: Bundle?): DreamProperties? {
            bundle ?: return null

            val description = bundle.getString(KEY_DESCRIPTION) ?: return null

            return DreamProperties(description)
        }
    }

}
