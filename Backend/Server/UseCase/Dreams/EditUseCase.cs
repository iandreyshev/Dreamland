using Dreamland.Domain;
using Dreamland.Storage.Account;
using Dreamland.Storage.Dreams;
using System;

namespace Dreamland.UseCase.Dreams
{
	public class EditUseCase
	{
		private IAccountStorage _accountStorage;
		private IDreamsStorage _dreamsStorage;

		public EditUseCase(
			IAccountStorage accountStorage,
			IDreamsStorage storage)
		{
			_accountStorage = accountStorage;
			_dreamsStorage = storage;
		}

		public Result Execute(string userIdStr, string userPassword, DreamProperties properties)
		{
			long userId = 0;

			try
			{
				userId = long.Parse(userIdStr);
			}
			catch (Exception)
			{
				return Result.ERROR_USER_NOT_EXISTS;
			}

			return _accountStorage.Transaction(Result.ERROR_UNDEFINED, _ =>
			{
				if (_accountStorage.Find(userId, userPassword) == null)
				{
					return Result.ERROR_USER_NOT_EXISTS;
				}

				_dreamsStorage.Update(new Dream
				{
					Id = properties.Id,
					UserId = userId,
					Description = properties.Description,
					IsLucid = properties.IsLucid ? 1 : 0,
					SleepingDate = properties.SleepingDate
				});

				return Result.SUCCESS;
			});
		}

		public enum Result
		{
			SUCCESS,
			ERROR_USER_NOT_EXISTS,
			ERROR_UNDEFINED
		};
	}
}
