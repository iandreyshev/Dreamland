package ru.iandreyshev.featureAccount.model.repository

interface IAccount {
    val login: String
    val password: String
    val fullName: String
    val avatarUrl: String
}
