package ru.iandreyshev.featureDreams.storage.converter

import io.objectbox.converter.PropertyConverter
import ru.iandreyshev.featureDreams.domain.SleepingDuration

class SleepingDurationConverter : PropertyConverter<SleepingDuration, Int> {

    override fun convertToDatabaseValue(entityProperty: SleepingDuration?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun convertToEntityProperty(databaseValue: Int?): SleepingDuration {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}