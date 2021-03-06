﻿using Dreamland.Controllers.Account.Response;
using Dreamland.Domain;
using Dreamland.UseCase.Account;

namespace Dreamland.Controllers.Account.Mapper
{
	public class AccountMapper
	{
		public static SignInResponse Map(SignInUseCase.Result result)
		{
			AccountResponse account = null;
			string error = null;

			switch (result.error)
			{
				case SignInUseCase.Result.Error.USER_NOT_EXISTS:
					error = "user_not_exists";
					break;
				case null:
					account = Map(result.user);
					break;
			}

			return new SignInResponse
			{
				Account = account,
				Error = error
			};
		}

		public static SignUpResponse Map(SignUpUseCase.Result result)
		{
			AccountResponse account = null;
			string error = null;

			switch (result.error)
			{
				case null:
					account = Map(result.user);
					break;
				case SignUpUseCase.Result.Error.ALREADY_EXISTS:
					error = "already_exists";
					break;
				case SignUpUseCase.Result.Error.INCORRECT_DATA:
					error = "incorrect_data";
					break;
			}

			return new SignUpResponse
			{
				Account = account,
				Error = error
			};
		}

		public static DeleteResponse Map(DeleteAccountUseCase.Result result)
		{
			string error = null;

			switch (result)
			{
				case DeleteAccountUseCase.Result.SUCCESS:
					break;
				case DeleteAccountUseCase.Result.ERROR_USER_NOT_EXISTS:
					error = "user_not_exists";
					break;
				case DeleteAccountUseCase.Result.ERROR_UNDEFINED:
					error = "undefined";
					break;
			}

			return new DeleteResponse
			{
				Error = error
			};
		}

		private static AccountResponse Map(User account)
		{
			if (account == null)
			{
				return null;
			}

			return new AccountResponse
			{
				Id = account.Id,
				Name = account.Name,
				AvatarUrl = account.AvatarUrl
			};
		}
	}
}
