package ru.iandreyshev.featureAccount.model.repository

import io.objectbox.BoxStore

class Builder {

    private lateinit var mBoxStore: BoxStore

    fun withStore(boxStore: BoxStore) = apply {
        mBoxStore = boxStore
    }

    fun build(): IUserRepository =
            UserRepository(mBoxStore)

}
