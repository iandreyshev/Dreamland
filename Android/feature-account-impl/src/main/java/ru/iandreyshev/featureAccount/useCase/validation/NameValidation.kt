package ru.iandreyshev.featureAccount.useCase.validation

private val NAME_LENGTH_RANGE = (1..128)

val String.isValidUserName: Boolean
    get() = length in NAME_LENGTH_RANGE