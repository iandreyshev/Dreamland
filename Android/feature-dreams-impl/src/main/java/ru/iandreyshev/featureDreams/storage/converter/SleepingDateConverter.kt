package ru.iandreyshev.featureDreams.storage.converter

import io.objectbox.converter.PropertyConverter
import ru.iandreyshev.featureDreams.domain.SleepingDate

class SleepingDateConverter : PropertyConverter<SleepingDate, Long> {

    override fun convertToDatabaseValue(entityProperty: SleepingDate?): Long {
        return 0
    }

    override fun convertToEntityProperty(databaseValue: Long?): SleepingDate {
        return SleepingDate(0)
    }

}