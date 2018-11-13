package ru.iandreyshev.featureAccountApi.repository

interface IUser {
    val login: String
    val password: String
    val fullName: String
    val avatarUrl: String
}
