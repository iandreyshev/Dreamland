using Dreamland.Domain;
using Dreamland.Storage.Account;
using Dreamland.Storage.Dreams;
using System;

namespace Dreamland.UseCase.Dreams
{
	public class SaveUseCase
	{
		private IAccountStorage _accountStorage;
		private IDreamsStorage _dreamsStorage;

		public SaveUseCase(
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
				return Result.UserNotExists;
			}

			return _accountStorage.Transaction(Result.UserNotExists, _ =>
			{
				if (_accountStorage.Find(userId, userPassword) == null)
				{
					return Result.UserNotExists;
				}

				var id = _dreamsStorage.Add(new Dream
				{
					UserId = userId,
					Description = properties.Description,
					IsLucid = properties.IsLucid ? 1 : 0,
					SleepingDate = properties.SleepingDate
				});

				return Result.Success(id);
			});
		}

		public class Result
		{
			public static Result UserNotExists
				=> new Result { error = Error.USER_NOT_EXISTS };

			public static Result Undefined
				=> new Result { error = Error.UNDEFINED };

			public static Result Success(long dreamId)
				=> new Result { dreamId = dreamId };

			public enum Error
			{
				USER_NOT_EXISTS,
				UNDEFINED
			};

			public long dreamId;
			public Error? error;
		}
	}
}
