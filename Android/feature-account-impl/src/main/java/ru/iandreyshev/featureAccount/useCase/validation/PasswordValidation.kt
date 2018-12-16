package ru.iandreyshev.featureAccount.useCase.validation

private val PASSWORD_LENGTH_RANGE = (6..64)

val String.isValidUserPassword: Boolean
    get() = length in PASSWORD_LENGTH_RANGE
