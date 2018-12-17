using Dreamland.Domain;
using Dreamland.Storage.Account;
using Dreamland.Storage.Dreams;
using System;
using System.Collections.Generic;

namespace Dreamland.UseCase.Dreams
{
	public class FetchUseCase
	{
		private IAccountStorage _accountStorage;
		private IDreamsStorage _dreamsStorage;

		public FetchUseCase(
			IAccountStorage accountStorage,
			IDreamsStorage storage)
		{
			_accountStorage = accountStorage;
			_dreamsStorage = storage;
		}

		public Result Execute(string userIdStr, string userPassword)
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

			if (_accountStorage.Find(userId, userPassword) == null)
			{
				return Result.UserNotExists;
			}

			return new Result
			{
				dreams = _dreamsStorage.All(userId)
			};
		}

		public class Result
		{
			public static Result Undefined
				=> new Result { error = Error.UNDEFINED };

			public static Result UserNotExists
				=> new Result { error = Error.USER_NOT_EXISTS };

			public enum Error
			{
				USER_NOT_EXISTS,
				UNDEFINED
			}

			public List<Dream> dreams = null;
			public Error? error = null;
		}
	}
}
