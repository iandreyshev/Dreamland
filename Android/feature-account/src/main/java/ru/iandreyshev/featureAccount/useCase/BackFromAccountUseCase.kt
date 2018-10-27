package ru.iandreyshev.featureAccount.useCase

import ru.iandreyshev.featureAccount.navigation.IAccountNavigator
import javax.inject.Inject

class BackFromAccountUseCase
@Inject constructor(
        private val navigator: IAccountNavigator
) : IBackFromAccountUseCase {

    override fun back() =
            navigator.onBackFromAccount()

}