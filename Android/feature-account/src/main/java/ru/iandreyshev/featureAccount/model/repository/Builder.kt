package ru.iandreyshev.featureAccount.model.repository

import android.content.Context

class Builder {

    private lateinit var mContext: Context

    fun withContext(context: Context) = apply {
        mContext = context
    }

    fun build(): IAccountRepository =
            AccountRepository(mContext)

}
