package ru.iandreyshev.featureAccount.useCase.validation

private val EMAIL_LENGTH_RANGE = (3..64)

val String.isValidUserEmail: Boolean
    get() = isNotEmpty()
            && isNotBlank()
            && contains("@")
            && length in EMAIL_LENGTH_RANGE
