using Dreamland.Storage.Account;
using Dreamland.Storage.Dreams;

namespace Dreamland.UseCase.Account
{
	public class DeleteAccountUseCase
	{
		private IAccountStorage _accountStorage;
		private IDreamsStorage _dreamsStorage;

		public DeleteAccountUseCase(
			IAccountStorage accountStorage,
			IDreamsStorage dreamsStorage)
		{
			_accountStorage = accountStorage;
			_dreamsStorage = dreamsStorage;
		}

		public Result Execute(string userIdString, string userPassword)
		{
			long userId = 0;

			try
			{
				userId = long.Parse(userIdString);
			}
			catch
			{
				return Result.ERROR_USER_NOT_EXISTS;
			}

			return _accountStorage.Transaction(Result.ERROR_UNDEFINED, _ =>
			{
				var user = _accountStorage.Find(userId, userPassword);

				if (user == null)
				{
					return Result.ERROR_USER_NOT_EXISTS;
				}

				_accountStorage.Delete(userId);
				_dreamsStorage.DeleteAllForUser(userId);

				return Result.SUCCESS;
			});
		}

		public enum Result
		{
			SUCCESS,
			ERROR_USER_NOT_EXISTS,
			ERROR_UNDEFINED
		}
	}
}