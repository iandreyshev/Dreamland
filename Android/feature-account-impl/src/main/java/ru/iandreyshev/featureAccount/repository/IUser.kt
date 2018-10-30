package ru.iandreyshev.featureAccount.repository

interface IUser {
    val login: String
    val password: String
    val fullName: String
    val avatarUrl: String
}
