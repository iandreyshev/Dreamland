using Dreamland.Storage.Account;

namespace Dreamland.UseCase.Account
{
	public class DeleteAccountUseCase
	{
		private IAccountStorage _storage;

		public DeleteAccountUseCase(IAccountStorage accountStorage)
		{
			_storage = accountStorage;
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
				return Result.ERROR_INCORRECT_DATA;
			}

			return _storage.Transaction(Result.ERROR_UNDEFINED, _ =>
			{
				var user = _storage.Find(userId, userPassword);

				if (user == null)
				{
					return Result.SUCCESS;
				}

				_storage.Delete(userId);

				return Result.SUCCESS;
			});
		}

		public enum Result
		{
			SUCCESS,
			ERROR_INCORRECT_DATA,
			ERROR_UNDEFINED
		}
	}
}