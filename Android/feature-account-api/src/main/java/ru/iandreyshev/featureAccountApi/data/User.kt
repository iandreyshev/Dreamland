package ru.iandreyshev.featureAccountApi.data

data class User(
        val id: Long,
        val login: String,
        val password: String,
        val fullName: String,
        val avatarUrl: String
)
