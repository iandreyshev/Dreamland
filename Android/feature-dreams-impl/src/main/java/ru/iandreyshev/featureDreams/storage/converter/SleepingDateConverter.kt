package ru.iandreyshev.featureDreams.storage.converter

import io.objectbox.converter.PropertyConverter
import ru.iandreyshev.featureDreams.domain.SleepingDate

class SleepingDateConverter : PropertyConverter<SleepingDate, Long> {

    override fun convertToDatabaseValue(entityProperty: SleepingDate?): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun convertToEntityProperty(databaseValue: Long?): SleepingDate {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}