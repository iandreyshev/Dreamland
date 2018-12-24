package ru.iandreyshev.featureDreams.ui.extension

import ru.iandreyshev.featureDreamsApi.domain.Dream
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties
import java.text.SimpleDateFormat

val Dream.dateViewString: String
    get() = properties.dateViewString

val DreamProperties.dateViewString: String
    get() = SimpleDateFormat("hh:mm:ss dd.MM.yyyy").format(sleepingDate.timesTemp)